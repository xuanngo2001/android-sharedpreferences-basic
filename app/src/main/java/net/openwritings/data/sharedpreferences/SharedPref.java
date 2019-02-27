package net.openwritings.data.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class SharedPref {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPref(Context context){
        this.preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        this.editor = this.preferences.edit();
    }

    public void add(String key, String value){
        this.editor.putString(key, value);
        this.editor.commit();
    }

    public String get(String key){
        return this.preferences.getString(key, "");
    }

    public void remove(String key){
        this.editor.remove(key);
        this.editor.commit();
    }

    public Map<String, ?> getAll(){
        return this.preferences.getAll();
    }
}
