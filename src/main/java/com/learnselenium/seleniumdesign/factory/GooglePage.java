package com.learnselenium.seleniumdesign.factory;

public abstract class GooglePage {

    public abstract void launchSite();
    public abstract void search(String keyword);
    public abstract int getResultsCount();

}
