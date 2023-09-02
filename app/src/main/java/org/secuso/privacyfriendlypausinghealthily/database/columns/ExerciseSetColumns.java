package org.secuso.privacyfriendlypausinghealthily.database.columns;

import android.content.ContentValues;
import android.database.Cursor;

import org.secuso.privacyfriendlypausinghealthily.database.data.ExerciseSet;


public final class ExerciseSetColumns {

    public static final String TABLE_NAME = "exercise_set";

    public static final String _ID = "exercise_set_id";
    public static final String NAME = "exercise_set_name";
    public static final String DEFAULT = "exercise_set_default";

    public static final String[] PROJECTION = {
            _ID,
            NAME,
            DEFAULT
    };

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static ExerciseSet fromCursor(Cursor c) {
        ExerciseSet e = new ExerciseSet();

        e.setId(c.getInt(c.getColumnIndexOrThrow(_ID)));
        e.setName(c.getString(c.getColumnIndexOrThrow(NAME)));
        e.setDefaultSet(c.getInt(c.getColumnIndexOrThrow(DEFAULT)) != 0);

        return e;
    }

    public static ContentValues getValues(ExerciseSet record) {
        ContentValues values = new ContentValues();

        if(record.getId() != -1) {
            values.put(_ID, record.getId());
            values.put(DEFAULT, record.isDefaultSet() ? 1 : 0);
        }
        values.put(NAME, record.getName());

        return values;
    }

    private ExerciseSetColumns() {}
}
