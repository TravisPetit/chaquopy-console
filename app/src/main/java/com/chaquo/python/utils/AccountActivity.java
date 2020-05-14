package com.chaquo.python.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.console.R;

import java.io.File;
import java.io.FilenameFilter;

public class AccountActivity extends BacNetActivity {

    public  String publicKey;
    public String privateKey;
    public String keyDirectory;
    private String fileExtension = ".key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        publicKey = getBaseContext().getFilesDir().getPath();
        Log.d("HERE", publicKey);
        //getAndSetPublicKey();
        //setText();
    }

    public class FileFilter implements FilenameFilter {

        private String fileExtension;

        public FileFilter(String fileExtension) {
            this.fileExtension = fileExtension;
        }

        @Override
        public boolean accept(File directory, String fileName) {
            return (fileName.endsWith(this.fileExtension));
        }
    }

    public void getAndSetPublicKey() {
        FileFilter fileFilter = new FileFilter(fileExtension);
        File parentDir = new File(keyDirectory);
        // Put the names of all files ending with .txt in a String array
        String[] listOfTextFiles = parentDir.list(fileFilter);

        if (listOfTextFiles.length == 0) {
            System.out.println("No public key!");
            return;
        }
        String s = "";
        for (String file : listOfTextFiles) {
            //construct the absolute file paths...
            String absoluteFilePath = new StringBuffer(keyDirectory).append(File.separator).append(file).toString();
            s = s + absoluteFilePath;
            System.out.println(absoluteFilePath);
        }
        publicKey = s;
    }

    public void setText() {
        TextView keyInfos = findViewById(R.id.keyPublicPrivate);
        keyInfos.setText(publicKey);
    }


    public static class Task extends DebugActivity.Task {
        public Task(Application app) {
            super(app);
        }

        @Override
        public void run() {
            py.getModule("main").callAttr("main");
        } //TODO
    }

    @Override
    protected Class<? extends AccountActivity.Task> getTaskClass() {
        return AccountActivity.Task.class;
    }
}
