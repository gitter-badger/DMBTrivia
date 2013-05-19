package com.jeffthefate.dmbquiz;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.slidingmenu.lib.SlidingMenu;

public interface OnButtonListener {
    public void setBackground(String name, boolean showNew, String screen);
    public void setlistBackground(String name, ImageViewEx background);
    /*
    public String getSplashBackground();
    public String getQuizBackground();
    public String getLeadersBackground();
    */
    public String getBackground();
    public void onInfoPressed(boolean fresh);
    public void onStatsPressed();
    public void onLoginPressed(int loginType, String user, String pass);
    public void setupUser(boolean newUser);
    public void showScoreDialog();
    public void showNameDialog();
    public void logOut(boolean force);
    public void startLogout();
    //public void loadSetlist();
    public Bundle getLeadersState();
    public void next();
    public String getQuestionId();
    public void setQuestionId(String questionId);
    public String getQuestion();
    public void setQuestion(String question);
    public String getCorrectAnswer();
    public void setCorrectAnswer(String correctAnswer);
    public String getQuestionScore();
    public void setQuestionScore(String questionScore);
    public String getQuestionCategory();
    public void setQuestionCategory(String questionCategory);
    public boolean getQuestionHint();
    public void setQuestionHint(boolean questionHint);
    public boolean getQuestionSkip();
    public String getNextQuestionId();
    public void setNextQuestionId(String nextQuestionId);
    public String getNextQuestion();
    public void setNextQuestion(String nextQuestion);
    public String getNextCorrectAnswer();
    public void setNextCorrectAnswer(String nextCorrectAnswer);
    public String getNextQuestionScore();
    public void setNextQuestionScore(String nextQuestionScore);
    public String getNextQuestionCategory();
    public boolean getNextQuestionHint();
    public void setNextQuestionHint(boolean nextQuestionHint);
    public boolean getNextQuestionSkip();
    public void setNextQuestionCategory(String nextQuestionCategory);
    public String getThirdQuestionId();
    public void setThirdQuestionId(String thirdQuestionId);
    public String getThirdQuestion();
    public void setThirdQuestion(String thirdQuestion);
    public String getThirdCorrectAnswer();
    public void setThirdCorrectAnswer(String thirdCorrectAnswer);
    public String getThirdQuestionScore();
    public void setThirdQuestionScore(String thirdQuestionScore);
    public String getThirdQuestionCategory();
    public void setThirdQuestionCategory(String thirdQuestionCategory);
    public boolean getThirdQuestionHint();
    public void setThirdQuestionHint(boolean thirdQuestionHint);
    public boolean getThirdQuestionSkip();
    public void getNextQuestions(boolean force, int level);
    public String getUserId();
    public String getDisplayName();
    public boolean isNewQuestion();
    public void setIsNewQuestion(boolean isNewQuestion);
    public int getCurrentScore();
    public void addCurrentScore(int addValue);
    public void shareScreenshot();
    public void setDisplayName(String displayName);
    public boolean getNetworkProblem();
    public void setNetworkProblem(boolean networkProblem);
    public void saveUserScore(final int currTemp);
    public void addCorrectAnswer(String correctId);
    public boolean isCorrectAnswer(String correctId);
    public void setUserName(String userName);
    public boolean isNewUser();
    public void resetPassword(String username);
    public int getWidth();
    public int getHeight();
    public boolean isLoggingOut();
    public void setLoggingOut(boolean loggingOut);
    public void setHomeAsUp(boolean homeAsUp);
    public void showQuickTip(View view, String message);
    public void showQuickTipMenu(ViewGroup view, String message, int location);
    public SlidingMenu slidingMenu();
    public boolean getGoToSetlist();
    public void setInSetlist(boolean inSetlist);
    public void setNewSetlist(boolean newSetlist);
    public boolean getInSetlist();
    public void refreshMenu();
    public BitmapDrawableEx getDrawable(int resId);
}