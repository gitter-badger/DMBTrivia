package com.jeffthefate.dmbquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.parse.ParseUser;

/**
 * Executes all the database actions, including many helper functions and
 * constants.
 * 
 * @author Jeff Fate
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    
    public static SQLiteDatabase db;
    
    private static final String DB_NAME = "dmbquizDb";
    
    public static final String USER_TABLE = "User";
    public static final String LEADER_TABLE = "Leader";
    
    public static final String COL_USER_ID = "UserId";
    public static final String COL_USER_TYPE = "Type";
    public static final String COL_SCORE = "Score";
    public static final String COL_OFFSET = "Offset";
    public static final String COL_CURR_QUESTION_ID = "CurrQuestionId";
    public static final String COL_CURR_QUESTION_QUESTION =
        "CurrQuestionQuestion";
    public static final String COL_CURR_QUESTION_ANSWER = "CurrQuestionAnswer";
    public static final String COL_CURR_QUESTION_CATEGORY =
        "CurrQuestionCategory";
    public static final String COL_CURR_QUESTION_SCORE = "CurrQuestionScore";
    public static final String COL_CURR_QUESTION_HINT = "CurrQuestionHint";
    public static final String COL_CURR_QUESTION_SKIP = "CurrQuestionSkip";
    public static final String COL_NEXT_QUESTION_ID = "NextQuestionId";
    public static final String COL_NEXT_QUESTION_QUESTION =
        "NextQuestionQuestion";
    public static final String COL_NEXT_QUESTION_ANSWER = "NextQuestionAnswer";
    public static final String COL_NEXT_QUESTION_CATEGORY =
        "NextQuestionCategory";
    public static final String COL_NEXT_QUESTION_SCORE = "NextQuestionScore";
    public static final String COL_NEXT_QUESTION_HINT = "NextQuestionHint";
    public static final String COL_NEXT_QUESTION_SKIP = "NextQuestionSkip";
    public static final String COL_THIRD_QUESTION_ID = "ThirdQuestionId";
    public static final String COL_THIRD_QUESTION_QUESTION =
        "ThirdQuestionQuestion";
    public static final String COL_THIRD_QUESTION_ANSWER =
        "ThirdQuestionAnswer";
    public static final String COL_THIRD_QUESTION_CATEGORY =
        "ThirdQuestionCategory";
    public static final String COL_THIRD_QUESTION_SCORE = "ThirdQuestionScore";
    public static final String COL_THIRD_QUESTION_HINT = "ThirdQuestionHint";
    public static final String COL_THIRD_QUESTION_SKIP = "ThirdQuestionSkip";
    public static final String COL_CURR_BACKGROUND = "CurrentBackground";
    public static final String COL_HINT = "Hint";
    public static final String COL_SKIP_TICK = "SkipTick";
    public static final String COL_HINT_TICK = "HintTick";
    public static final String COL_SKIP_PRESSED = "SkipPressed";
    public static final String COL_HINT_PRESSED = "HintPressed";
    public static final String COL_IS_CORRECT = "IsCorrect";
    public static final String COL_LOGGED_IN = "LoggedIn";
    public static final String COL_LOGGING = "Logging";
    public static final String COL_IN_LOAD = "InLoad";
    public static final String COL_IN_STATS = "InStats";
    public static final String COL_IN_INFO = "InInfo";
    public static final String COL_NEW_QUESTION = "NewQuestion";
    public static final String COL_DISPLAY_NAME = "DisplayName";
    public static final String COL_NETWORK_PROBLEM = "NetworkProblem";
    public static final String COL_SKIP_VIS = "SkipVis";
    
    public static final String COL_USER_TEXT = "UserText";
    public static final String COL_USER_ANSWER_TEXT = "UserAnswerText";
    public static final String COL_USER_ANSWERS = "UserAnswers";
    public static final String COL_USER_HINT_TEXT = "UserHintText";
    public static final String COL_USER_HINTS = "UserHints";
    public static final String COL_USER_NAME_TEXT = "UserNameText";
    public static final String COL_USER_SCORE_TEXT = "UserScoreText";
    public static final String COL_LEADER_TEXT = "LeaderText";
    public static final String COL_CREATED_TEXT = "CreatedText";
    public static final String COL_CREATED_DATE = "CreatedDate";
    
    public static final String COL_RANK = "Rank";
    public static final String COL_USER = "User";
    public static final String COL_LEADER_SCORE = "Score";
    public static final String COL_LEADER_ID = "LeaderId";
    /**
     * Create User table string
     */
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE
            + " (" + COL_USER_ID + " STRING PRIMARY KEY, " + COL_USER_TYPE +
            " TEXT, " + COL_SCORE + " INTEGER DEFAULT -1, " + COL_OFFSET +
            " INTEGER DEFAULT 0, " + COL_CURR_QUESTION_ID + " TEXT, " +
            COL_CURR_QUESTION_QUESTION + " TEXT, " + COL_CURR_QUESTION_ANSWER +
            " TEXT, " + COL_CURR_QUESTION_CATEGORY + " TEXT, " +
            COL_CURR_QUESTION_SCORE + " TEXT, " + COL_CURR_QUESTION_HINT +
            " INTEGER DEFAULT 0, " + COL_CURR_QUESTION_SKIP +
            " INTEGER DEFAULT 0, " + COL_NEXT_QUESTION_ID + " TEXT, " +
            COL_NEXT_QUESTION_QUESTION + " TEXT, " + COL_NEXT_QUESTION_ANSWER +
            " TEXT, " + COL_NEXT_QUESTION_CATEGORY + " TEXT, " +
            COL_NEXT_QUESTION_SCORE + " TEXT, " + COL_NEXT_QUESTION_HINT +
            " INTEGER DEFAULT 0, " + COL_NEXT_QUESTION_SKIP +
            " INTEGER DEFAULT 0, " + COL_THIRD_QUESTION_ID + " TEXT, " +
            COL_THIRD_QUESTION_QUESTION + " TEXT, " + COL_THIRD_QUESTION_ANSWER
            + " TEXT, " + COL_THIRD_QUESTION_CATEGORY + " TEXT, " +
            COL_THIRD_QUESTION_SCORE + " TEXT, " + COL_THIRD_QUESTION_HINT +
            " INTEGER DEFAULT 0, " + COL_THIRD_QUESTION_SKIP +
            " INTEGER DEFAULT 0, " + COL_CURR_BACKGROUND + " TEXT, " +
            COL_HINT + " TEXT, " + COL_SKIP_TICK +
            " INTEGER DEFAULT -1, " + COL_HINT_TICK + " INTEGER DEFAULT -1, " +
            COL_SKIP_PRESSED + " INTEGER DEFAULT 0, " + COL_HINT_PRESSED +
            " INTEGER DEFAULT 0, " + COL_IS_CORRECT + " INTEGER DEFAULT 0, " +
            COL_NETWORK_PROBLEM + " INTEGER DEFAULT 0, " + COL_LOGGED_IN +
            " INTEGER DEFAULT 0, " + COL_LOGGING + " INTEGER DEFAULT 0, " +
            COL_IN_LOAD + " INTEGER DEFAULT 0, " + COL_IN_STATS +
            " INTEGER DEFAULT 0, " + COL_IN_INFO + " INTEGER DEFAULT 0, " +
            COL_NEW_QUESTION + " INTEGER DEFAULT 0, " + COL_DISPLAY_NAME +
            " TEXT, " + COL_USER_TEXT + " TEXT, " + COL_USER_ANSWER_TEXT +
            " TEXT, " + COL_USER_ANSWERS + " TEXT, " + COL_USER_HINT_TEXT +
            " TEXT, " + COL_USER_HINTS + " TEXT, " + COL_USER_NAME_TEXT +
            " TEXT, " + COL_USER_SCORE_TEXT + " TEXT, " + COL_LEADER_TEXT +
            " TEXT, " + COL_CREATED_TEXT + " TEXT, " + COL_CREATED_DATE +
            " TEXT, " + COL_SKIP_VIS + " INTEGER DEFAULT 0)";
    /**
     * Create Question table string
     */
    private static final String CREATE_LEADER_TABLE = "CREATE TABLE " +
            LEADER_TABLE + " (" + COL_USER_ID + " TEXT, " + COL_RANK + " TEXT, "
            + COL_USER + " TEXT, " + COL_LEADER_SCORE + " TEXT, " +
            COL_LEADER_ID + " TEXT)";
    /**
     * Create the helper object that creates and manages the database.
     * 
     * @param context
     *            the context used to create this object
     */
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        db = getWritableDatabase();
    }
    
    private static DatabaseHelper instance;
    
    public static synchronized DatabaseHelper getInstance() {
        if (instance == null)
            instance = new DatabaseHelper(ApplicationEx.getApp());
        return instance;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_LEADER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LEADER_TABLE);
        onCreate(db);
    }    
    /**
     * Insert a new record into a table in the database.
     * 
     * @param cv
     *            list of content values to be entered
     * @param tableName
     *            the table name to be inserted into
     * @param columnName
     *            the column that isn't null if the rest are null
     * @return the row id of the inserted row
     */
    public long insertRecord(ContentValues cv, String tableName,
            String columnName) {
        return db.insert(tableName, columnName, cv);
    }
    
    /**
     * Update a record in a table in the database.
     * 
     * @param cv
     *            list of content values to be entered
     * @param tableName
     *            the table name to be inserted into
     * @param whereClause
     *            what to look for
     * @return the number of rows affected
     */
    public long updateRecord(ContentValues cv, String tableName,
            String whereClause, String[] selectionArgs) {
        int result = -1;
        try {
            result = db.update(tableName, cv, whereClause, selectionArgs);
        } catch (IllegalArgumentException e) {}
        return result;
    }
    
    public boolean hasUser(String userId) {
        Cursor cur = db.query(USER_TABLE, new String[] {}, COL_USER_ID + "=?",
                new String[] {userId}, null, null, null);
        boolean hasUser = false;
        if (cur.getCount() > 0)
            hasUser = true;
        cur.close();
        return hasUser;
    }
    
    public void addUser(ParseUser user, String type) {
        ContentValues cv = new ContentValues();
        cv.put(COL_USER_ID, user.getObjectId());
        cv.put(COL_USER_TYPE, type);
        cv.put(COL_SCORE, user.getString("score"));
        cv.put(COL_OFFSET, 1);
        insertRecord(cv, USER_TABLE, COL_USER_ID);
    }
    
    public void addLeader(String userId, String rank, String user, String score,
            String id) {
        ContentValues cv = new ContentValues();
        cv.put(COL_USER_ID, userId);
        cv.put(COL_RANK, rank);
        cv.put(COL_USER, user);
        cv.put(COL_LEADER_SCORE, score);
        cv.put(COL_LEADER_ID, id);
        insertRecord(cv, LEADER_TABLE, COL_USER);
    }
    
    public String getLeaderUserId() {
        Cursor cur = db.query(LEADER_TABLE, new String[] {COL_USER_ID}, null,
                null, null, null, null, "1");
        String userId = null;
        if (cur.moveToFirst())
            userId = cur.getString(cur.getColumnIndex(COL_USER_ID));
        cur.close();
        return userId;
    }
    
    public long setUserValue(String value, String column, String userId) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        if (userId != null)
            return updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                    new String[] {userId});
        else
            return -1;
    }
    
    public long setUserValue(int value, String column, String userId) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        if (userId != null)
            return updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                    new String[] {userId});
        else
            return -1;
    }
    
    public String getUserStringValue(String column, String userId) {
        if (userId != null) {
            Cursor cur = db.query(USER_TABLE, new String[] {column},
                    COL_USER_ID + "=?", new String[] {userId}, null, null,
                    null);
            String value = "";
            if (cur.moveToFirst())
                value = cur.getString(cur.getColumnIndex(column));
            cur.close();
            return value;
        }
        else
            return "";
    }
    
    public int getUserIntValue(String column, String userId) {
        if (userId != null) {
            Cursor cur = db.query(USER_TABLE, new String[] {column},
                    COL_USER_ID + "=?", new String[] {userId}, null, null,
                    null);
            int value = -1;
            if (cur.moveToFirst())
                value = cur.getInt(cur.getColumnIndex(column));
            cur.close();
            return value;
        }
        else
            return -1;
    }
    
    public ArrayList<String> getLeaderRanks() {
        Cursor cur = db.query(LEADER_TABLE, new String[] {COL_RANK}, null,
                new String[] {}, null, null, null);
        ArrayList<String> rankList = new ArrayList<String>();
        if (cur.moveToFirst()) {
            do {
                rankList.add(cur.getString(cur.getColumnIndex(COL_RANK)));
            } while (cur.moveToNext());
        }
        cur.close();
        return rankList;
    }
    
    public ArrayList<String> getLeaderUsers() {
        Cursor cur = db.query(LEADER_TABLE, new String[] {COL_USER}, null,
                new String[] {}, null, null, null);
        ArrayList<String> userList = new ArrayList<String>();
        if (cur.moveToFirst()) {
            do {
                userList.add(cur.getString(cur.getColumnIndex(COL_USER)));
            } while (cur.moveToNext());
        }
        cur.close();
        return userList;
    }
    
    public ArrayList<String> getLeaderScores() {
        Cursor cur = db.query(LEADER_TABLE, new String[] {COL_LEADER_SCORE},
                null, new String[] {}, null, null, null);
        ArrayList<String> scoreList = new ArrayList<String>();
        if (cur.moveToFirst()) {
            do {
                scoreList.add(cur.getString(cur.getColumnIndex(
                        COL_LEADER_SCORE)));
            } while (cur.moveToNext());
        }
        cur.close();
        return scoreList;
    }
    
    public ArrayList<String> getLeaderIds() {
        Cursor cur = db.query(LEADER_TABLE, new String[] {COL_LEADER_ID},
                null, new String[] {}, null, null, null);
        ArrayList<String> userIdList = new ArrayList<String>();
        if (cur.moveToFirst()) {
            do {
                userIdList.add(cur.getString(cur.getColumnIndex(
                        COL_LEADER_ID)));
            } while (cur.moveToNext());
        }
        cur.close();
        return userIdList;
    }
    
    public void clearLeaders() {
        db.delete(LEADER_TABLE, null, null);
    }
    
    public boolean isAnonUser(String userId) {
        Cursor cur = db.query(USER_TABLE, new String[] {}, COL_USER_ID + "=?",
                new String[] {userId}, null, null, null);
        boolean isAnon = false;
        if (cur.moveToFirst()) {
            if (cur.getString(cur.getColumnIndex(COL_USER_TYPE))
                    .equals("Anonymous"))
                isAnon = true;
        }
        cur.close();
        return isAnon;
    }
    
    public long setScore(int score, String userId) {
        ContentValues cv = new ContentValues();
        cv.put(COL_SCORE, score);
        if (userId != null)
            return updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                    new String[] {userId});
        else
            return -1;
    }
    
    public int getScore(String userId) {
        if (userId == null)
            return -2;
        Cursor cur = db.query(USER_TABLE, new String[] {COL_SCORE},
                COL_USER_ID + "=?", new String[] {userId}, null, null, null);
        int score = 0;
        if (cur.moveToFirst())
            score = cur.getInt(cur.getColumnIndex(COL_SCORE));
        cur.close();
        return score;
    }
    
    public long setOffset(int offset, String userId) {
        ContentValues cv = new ContentValues();
        cv.put(COL_OFFSET, offset);
        return updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                new String[] {userId});
    }
    
    public String getCurrUser() {
        Cursor cur = db.query(USER_TABLE, new String[] {COL_USER_ID},
                COL_OFFSET + "=?", new String[] {"1"}, null, null, null);
        String userId = null;
        if (cur.moveToFirst())
            userId = cur.getString(cur.getColumnIndex(COL_USER_ID));
        cur.close();
        return userId;
    }
    
    public long setQuestions(String userObject, String currQuestionId,
            String currQuestionQuestion, String currQuestionAnswer,
            String currQuestionCategory, String currQuestionScore,
            boolean currQuestionHint, boolean currQuestionSkip,
            String nextQuestionId, String nextQuestionQuestion,
            String nextQuestionAnswer, String nextQuestionCategory,
            String nextQuestionScore, boolean nextQuestionHint,
            boolean nextQuestionSkip, String thirdQuestionId,
            String thirdQuestionQuestion, String thirdQuestionAnswer,
            String thirdQuestionCategory, String thirdQuestionScore,
            boolean thirdQuestionHint, boolean thirdQuestionSkip) {
        ContentValues cv = new ContentValues();
        cv.put(COL_CURR_QUESTION_ID, currQuestionId);
        cv.put(COL_CURR_QUESTION_QUESTION, currQuestionQuestion);
        cv.put(COL_CURR_QUESTION_ANSWER, currQuestionAnswer);
        cv.put(COL_CURR_QUESTION_CATEGORY, currQuestionCategory);
        cv.put(COL_CURR_QUESTION_SCORE, currQuestionScore);
        cv.put(COL_CURR_QUESTION_HINT, currQuestionHint ? 1 : 0);
        cv.put(COL_CURR_QUESTION_SKIP, currQuestionSkip ? 1 : 0);
        cv.put(COL_NEXT_QUESTION_ID, nextQuestionId);
        cv.put(COL_NEXT_QUESTION_QUESTION, nextQuestionQuestion);
        cv.put(COL_NEXT_QUESTION_ANSWER, nextQuestionAnswer);
        cv.put(COL_NEXT_QUESTION_CATEGORY, nextQuestionCategory);
        cv.put(COL_NEXT_QUESTION_SCORE, nextQuestionScore);
        cv.put(COL_NEXT_QUESTION_HINT, nextQuestionHint ? 1 : 0);
        cv.put(COL_NEXT_QUESTION_SKIP, nextQuestionSkip ? 1 : 0);
        cv.put(COL_THIRD_QUESTION_ID, thirdQuestionId);
        cv.put(COL_THIRD_QUESTION_QUESTION, thirdQuestionQuestion);
        cv.put(COL_THIRD_QUESTION_ANSWER, thirdQuestionAnswer);
        cv.put(COL_THIRD_QUESTION_CATEGORY, thirdQuestionCategory);
        cv.put(COL_THIRD_QUESTION_SCORE, thirdQuestionScore);
        cv.put(COL_THIRD_QUESTION_HINT, thirdQuestionHint ? 1 : 0);
        cv.put(COL_THIRD_QUESTION_SKIP, thirdQuestionSkip ? 1 : 0);
        return updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                new String[] {userObject});
    }
    
    public String getCurrQuestionId(String userObject) {
        Cursor cur = db.query(USER_TABLE, new String[] {COL_CURR_QUESTION_ID},
                COL_USER_ID + "=?", new String[] {userObject}, null, null,
                null);
        String currQuestionId = null;
        if (cur.moveToFirst())
            currQuestionId = cur.getString(
                    cur.getColumnIndex(COL_CURR_QUESTION_ID));
        cur.close();
        return currQuestionId;
    }
    
    public String getCurrQuestionQuestion(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_QUESTION}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_CURR_QUESTION_QUESTION));
        cur.close();
        return currQuestion;
    }
    
    public String getCurrQuestionAnswer(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_ANSWER}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_CURR_QUESTION_ANSWER));
        cur.close();
        return currQuestion;
    }
    
    public String getCurrQuestionCategory(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_CATEGORY}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_CURR_QUESTION_CATEGORY));
        cur.close();
        return currQuestion;
    }
    
    public String getCurrQuestionScore(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_SCORE}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_CURR_QUESTION_SCORE));
        cur.close();
        return currQuestion;
    }
    
    public boolean getCurrQuestionHint(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_HINT}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currHint = false;
        if (cur.moveToFirst())
            currHint = cur.getInt(cur.getColumnIndex(COL_CURR_QUESTION_HINT))
                    == 1;
        cur.close();
        return currHint;
    }
    
    public boolean getCurrQuestionSkip(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_CURR_QUESTION_SKIP}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currSkip = false;
        if (cur.moveToFirst())
            currSkip = cur.getInt(cur.getColumnIndex(COL_CURR_QUESTION_SKIP))
                    == 1;
        cur.close();
        return currSkip;
    }
    
    public String getNextQuestionId(String userObject) {
        Cursor cur = db.query(USER_TABLE, new String[] {COL_NEXT_QUESTION_ID},
                COL_USER_ID + "=?", new String[] {userObject}, null, null,
                null);
        String nextQuestionId = null;
        if (cur.moveToFirst())
            nextQuestionId = cur.getString(
                    cur.getColumnIndex(COL_NEXT_QUESTION_ID));
        cur.close();
        return nextQuestionId;
    }
    
    public String getNextQuestionQuestion(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_QUESTION}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_NEXT_QUESTION_QUESTION));
        cur.close();
        return currQuestion;
    }
    
    public String getNextQuestionAnswer(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_ANSWER}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_NEXT_QUESTION_ANSWER));
        cur.close();
        return currQuestion;
    }
    
    public String getNextQuestionCategory(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_CATEGORY}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_NEXT_QUESTION_CATEGORY));
        cur.close();
        return currQuestion;
    }
    
    public String getNextQuestionScore(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_SCORE}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_NEXT_QUESTION_SCORE));
        cur.close();
        return currQuestion;
    }
    
    public boolean getNextQuestionHint(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_HINT}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currHint = false;
        if (cur.moveToFirst())
            currHint = cur.getInt(cur.getColumnIndex(COL_NEXT_QUESTION_HINT))
                    == 1;
        cur.close();
        return currHint;
    }
    
    public boolean getNextQuestionSkip(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_NEXT_QUESTION_SKIP}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currSkip = false;
        if (cur.moveToFirst())
            currSkip = cur.getInt(cur.getColumnIndex(COL_NEXT_QUESTION_SKIP))
                    == 1;
        cur.close();
        return currSkip;
    }
    
    public String getThirdQuestionId(String userObject) {
        Cursor cur = db.query(USER_TABLE, new String[] {COL_THIRD_QUESTION_ID},
                COL_USER_ID + "=?", new String[] {userObject}, null, null,
                null);
        String nextQuestionId = null;
        if (cur.moveToFirst())
            nextQuestionId = cur.getString(
                    cur.getColumnIndex(COL_THIRD_QUESTION_ID));
        cur.close();
        return nextQuestionId;
    }
    
    public String getThirdQuestionQuestion(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_QUESTION}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_THIRD_QUESTION_QUESTION));
        cur.close();
        return currQuestion;
    }
    
    public String getThirdQuestionAnswer(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_ANSWER}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_THIRD_QUESTION_ANSWER));
        cur.close();
        return currQuestion;
    }
    
    public String getThirdQuestionCategory(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_CATEGORY}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_THIRD_QUESTION_CATEGORY));
        cur.close();
        return currQuestion;
    }
    
    public String getThirdQuestionScore(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_SCORE}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        String currQuestion = null;
        if (cur.moveToFirst())
            currQuestion = cur.getString(
                    cur.getColumnIndex(COL_THIRD_QUESTION_SCORE));
        cur.close();
        return currQuestion;
    }
    
    public boolean getThirdQuestionHint(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_HINT}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currHint = false;
        if (cur.moveToFirst())
            currHint = cur.getInt(cur.getColumnIndex(COL_THIRD_QUESTION_HINT))
                    == 1;
        cur.close();
        return currHint;
    }
    
    public boolean getThirdQuestionSkip(String userObject) {
        Cursor cur = db.query(USER_TABLE,
                new String[] {COL_THIRD_QUESTION_SKIP}, COL_USER_ID + "=?",
                new String[] {userObject}, null, null, null);
        boolean currSkip = false;
        if (cur.moveToFirst())
            currSkip = cur.getInt(cur.getColumnIndex(COL_THIRD_QUESTION_SKIP))
                    == 1;
        cur.close();
        return currSkip;
    }
    
    public long setCurrBackground(String userId, String currBackground) {
        long returnValue = -1;
        ContentValues cv = new ContentValues();
        cv.put(COL_CURR_BACKGROUND, currBackground);
        returnValue = updateRecord(cv, USER_TABLE, COL_USER_ID + "=?",
                new String[] {userId});
        return returnValue;
    }
    
    public String getCurrBackground(String userId) {
        Cursor cur = db.query(USER_TABLE, new String[] {COL_CURR_BACKGROUND},
                COL_USER_ID + "=?", new String[] {userId}, null, null, null);
        String background = null;
        if (cur.moveToFirst())
            background = cur.getString(cur.getColumnIndex(COL_CURR_BACKGROUND));
        cur.close();
        return background;
    }
    
    public void checkUpgrade() {
        Cursor cur = db.query(USER_TABLE, null, null, null, null, null, null);
        String[] colArray = cur.getColumnNames();
        List<String> colList = Arrays.asList(colArray);
        cur.close();
        String sqlString;
        if (!colList.contains(COL_CURR_QUESTION_HINT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_CURR_QUESTION_HINT + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_CURR_QUESTION_SKIP)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_CURR_QUESTION_SKIP + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_NEXT_QUESTION_HINT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_NEXT_QUESTION_HINT + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_NEXT_QUESTION_SKIP)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_NEXT_QUESTION_SKIP + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_HINT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_HINT + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_SKIP)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_SKIP + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_ID)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_ID + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_QUESTION)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_QUESTION + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_ANSWER)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_ANSWER + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_CATEGORY)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_CATEGORY + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_THIRD_QUESTION_SCORE)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_THIRD_QUESTION_SCORE + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_HINT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_HINT +
                    " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_SKIP_TICK)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_SKIP_TICK +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_HINT_TICK)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_HINT_TICK +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_SKIP_PRESSED)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_SKIP_PRESSED
                    + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_HINT_PRESSED)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_HINT_PRESSED
                    + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_IS_CORRECT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_IS_CORRECT +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_NETWORK_PROBLEM)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_NETWORK_PROBLEM + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_LOGGING)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_LOGGING +
            " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_LOGGED_IN)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_LOGGED_IN +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_IN_LOAD)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_IN_LOAD +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_IN_STATS)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_IN_STATS +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_IN_INFO)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_IN_INFO +
                    " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_NEW_QUESTION)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_NEW_QUESTION
                    + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_DISPLAY_NAME)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_DISPLAY_NAME
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_USER_TEXT
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_ANSWER_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_USER_ANSWER_TEXT + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_ANSWERS)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_USER_ANSWERS
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_HINT_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_USER_HINT_TEXT + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_HINTS)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_USER_HINTS
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_NAME_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_USER_NAME_TEXT + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_USER_SCORE_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " +
                    COL_USER_SCORE_TEXT + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_LEADER_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_LEADER_TEXT
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_CREATED_TEXT)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_CREATED_TEXT
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_CREATED_DATE)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_CREATED_DATE
                    + " TEXT";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        if (!colList.contains(COL_SKIP_VIS)) {
            sqlString = "ALTER TABLE " + USER_TABLE + " ADD " + COL_SKIP_VIS
                    + " INTEGER DEFAULT 0";
            try {
                db.execSQL(sqlString);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " + sqlString, e);
            }
        }
        boolean upgrade = true;
        cur = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",
                null);
        if (cur.moveToFirst()) {
            do {
                if (cur.getString(cur.getColumnIndex("name")).equals(
                        LEADER_TABLE))
                    upgrade = false;
            } while (cur.moveToNext());
        }
        if (upgrade) {
            try {
                db.execSQL(CREATE_LEADER_TABLE);
            } catch (SQLException e) {
                Log.e(Constants.LOG_TAG, "Bad SQL string: " +
                        CREATE_LEADER_TABLE);
            }
        }
    }
    
}