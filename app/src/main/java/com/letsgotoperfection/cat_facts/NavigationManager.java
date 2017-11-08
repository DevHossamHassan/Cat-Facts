package com.letsgotoperfection.cat_facts;

/**
 * @author hossam.
 */


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.text.TextUtils;

public class NavigationManager {
    private FragmentManager mFragmentManager;

    public NavigationManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    /**
     * Displays the next fragment
     *
     * @param fragment
     */
    @SuppressLint("ResourceType")
    public void attach(Fragment fragment, boolean isAnimated, String tag) {
        if (mFragmentManager != null && !isAtTheTopOnBackStack(tag)) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();

            if (isAnimated)
                ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
            if (!TextUtils.isEmpty(tag))
                ft.addToBackStack(tag);
            ft.replace(R.id.container_main_frame_layout, fragment);
            ft.commit();
        }
    }

    @SuppressLint("ResourceType")
    public void attach(Fragment fragment, int containerId, boolean isAnimated, String tag) {
        if (mFragmentManager != null && !isAtTheTopOnBackStack(tag)) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();

            if (isAnimated)
                ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
            if (!TextUtils.isEmpty(tag))
                ft.addToBackStack(tag);
            ft.add(containerId, fragment, tag);
            ft.commit();
        }
    }

    public void attachAsRoot(Fragment fragment) {
        if (mFragmentManager != null) {
            for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); i++)
                mFragmentManager.popBackStackImmediate();
            attach(fragment, false, "");
        }
    }

    /**
     * @return true if stack has been popped succesfully, false if the stack has one element
     */
    public boolean popBackStackImmediate() {
        if (mFragmentManager == null) return false;
        if (mFragmentManager.getBackStackEntryCount() == 0) {
            return false;
        } else {
            mFragmentManager.popBackStackImmediate();
            return true;
        }
    }

    private boolean isAtTheTopOnBackStack(String tag) {
        if (mFragmentManager.getBackStackEntryCount() == 0) return false;
        return TextUtils.equals(mFragmentManager.getBackStackEntryAt(mFragmentManager
                .getBackStackEntryCount() - 1).getName(), tag);
    }

    /**
     * Navigates back by popping teh back stack. If there is no more items left we finish the
     * current activity.
     *
     * @param baseActivity
     */
    public void navigateBack(Activity baseActivity) {

        if (mFragmentManager.getBackStackEntryCount() == 0) {
            // we can finish the base activity since we have no other fragments
            baseActivity.finish();
        } else {
            mFragmentManager.popBackStackImmediate();
        }
    }

    public boolean isBackstackEmpty() {
        return mFragmentManager.getBackStackEntryCount() == 0;
    }

    public int getBackstackEntryCount() {
        return mFragmentManager.getBackStackEntryCount();
    }
}