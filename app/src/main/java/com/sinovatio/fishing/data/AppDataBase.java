package com.sinovatio.fishing.data;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sinovatio.fishing.STApplication;
import com.sinovatio.fishing.data.dao.SecHunterDao;
import com.sinovatio.fishing.data.entity.SecHunterEntity;

/**
 * @author zjp1002038
 */
@Database(entities = {SecHunterEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "st_db";

    private static AppDataBase databaseInstance;

    public static synchronized AppDataBase getInstance()
    {
        if(databaseInstance == null)
        {
            databaseInstance = Room
                    .databaseBuilder(STApplication.application, AppDataBase.class, DATABASE_NAME)
                    .build();
        }
        return databaseInstance;
    }

    public abstract SecHunterDao secHunterDao();
}
