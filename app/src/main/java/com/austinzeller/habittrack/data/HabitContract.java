package com.austinzeller.habittrack.data;

import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract() {
    }
    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = "_id";
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_STATUS = "status";

        public static final int STATUS_INCOMPLETE = 0;
        public static final int STATUS_COMPLETED = 1;
    }
}
