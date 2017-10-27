/*
Copyright 2016 Dreamcode Developer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package id.dreamcode.listview;

import id.dreamcode.listview.ListAdapter.ListAction;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private final String HALAMAN1 = "Halaman 1";
	private final String HALAMAN2 = "Halaman 2";
	private final String HALAMAN3 = "Halaman 3";
	private final String HALAMAN4 = "Halaman 4";
	private final String KELUAR = "Keluar";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView list = (ListView)findViewById(R.id.mainAct_list);
		ListAdapter adapter = new ListAdapter(getData());
		adapter.setOnListActionClicked(new ListAction() {
			
			@Override
			public void openMenu(String menuName) {
				startActivity(menuName);
			}
		});
		list.setAdapter(adapter);
	}

  
	private void startActivity(String menuList)
	{   
		switch (menuList) {
		case HALAMAN1: startActivity(new Intent(MainActivity.this, Halaman1.class)); break;
		case HALAMAN2: startActivity(new Intent(MainActivity.this, Halaman2.class)); break;
		case HALAMAN3: startActivity(new Intent(MainActivity.this, Halaman3.class)); break;
		case HALAMAN4: startActivity(new Intent(MainActivity.this, Halaman4.class)); break;
		default: finish(); break;
		}
	}
  
  
  private List<String> getData() 
  {
    List<String> data = new ArrayList<String>();  
    data.add(HALAMAN1);
    data.add(HALAMAN2);
    data.add(HALAMAN3);
    data.add(HALAMAN4);
    data.add(KELUAR);
    
    return data;
  }

}
