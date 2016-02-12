package mx.appdata.roberasd.myapplication.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import mx.appdata.roberasd.myapplication.R;

/**
 * Created by Roberasd on 03/02/2016.
 */
public class ThreadFragment extends Fragment {

    private ProgressBar mProgressBar;
    private ProgressDialog mProgressDialog;
    private Button mButtonWithOutThread;
    private Button mButtonWithThread;

    public static ThreadFragment newInstance(){
        ThreadFragment threadFragment = new ThreadFragment();
        return threadFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thread_fragment_layot,
                container, false);

        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mButtonWithOutThread = (Button) view.findViewById(R.id.buttonWithOutThread);
        mButtonWithThread = (Button) view.findViewById(R.id.buttonWithThread);

        mButtonWithOutThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withOutThread();

            }
        });

        mButtonWithThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //withThreadOptionOne();
                withThreadOptionTwo();

            }
        });


        return view;
    }

    private void withThreadOptionTwo() {
        AsynTaskProgressBar asynTaskProgressBar = new AsynTaskProgressBar();
        asynTaskProgressBar.execute();
    }

    private class AsynTaskProgressBar extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {
            for(int i=1; i<=10; i++) {
                sleepProcess();

                publishProgress(i*10);

                if(isCancelled())
                    break;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progress = values[0].intValue();

            mProgressBar.setProgress(progress);
        }

        @Override
        protected void onPreExecute() {
            mProgressBar.setMax(100);
            mProgressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            if(aBoolean)
                Toast.makeText(getActivity(),
                        "Hilo finalizado", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getActivity(),
                    "Hilo cancelado", Toast.LENGTH_SHORT).show();
        }
    }

    private void withThreadOptionOne() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressBar.setProgress(0);
                    }
                });

                for(int i = 1; i <= 10; i++){
                    sleepProcess();
                    mProgressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.incrementProgressBy(10);
                        }
                    });
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "Terminado! ;)",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    private void withOutThread() {
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);

        for(int i=1; i <= 10; i++){
           sleepProcess();
            mProgressBar.incrementProgressBy(10);
        }
    }

    private void sleepProcess() {
        try{
            Thread.sleep(1000);

        }catch(Exception e){
            Log.e("Error!", "error:: " + e.getMessage());
        }
    }
}
