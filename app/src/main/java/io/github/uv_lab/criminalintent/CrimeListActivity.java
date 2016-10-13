package io.github.uv_lab.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by youwei on 2016/10/13.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
