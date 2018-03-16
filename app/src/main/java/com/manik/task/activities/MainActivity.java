package com.manik.task.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.manik.task.R;
import com.manik.task.callbacks.ContactFetchListner;
import com.manik.task.managers.ContactManager;
import com.manik.task.model.Contact;
import com.manik.task.ui.adapter.ContactListAdapter;

import java.util.List;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 16-03-2018
 */
public class MainActivity extends BaseActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private Context mContext;
    private RecyclerView mContactListView;
    private ContactManager mContactManager;
    private ContactListAdapter mContactListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        setupView();
    }

    @Override
    public void init() {
        mContext = MainActivity.this;
        mContactManager = new ContactManager(this);

        mContactListView = findViewById(R.id.contact_listview);
        mContactListView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setupView() {
        mContactManager.getAllContact(new ContactFetchListner() {
            @Override
            public void onContactFetchedSuccessfully(Contact[] contacts) {
                mContactListAdapter = new ContactListAdapter(contacts);
                mContactListView.setAdapter(mContactListAdapter);
            }

            @Override
            public void onContactFatchedFailed(int errorCode) {
                Toast.makeText(mContext, "Error in fetching contacts", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}


