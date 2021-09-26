package com.sinovatio.fishing.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sinovatio.fishing.data.entity.SecHunterEntity;

import java.util.List;

/**
 * @author zjp1002038
 */
@Dao
public interface SecHunterDao {

    @Insert
    void insertSecHunter(SecHunterEntity secHunter);

    @Query("select * from SecHunterEntity where type = :type")
    List<SecHunterEntity> getSecHunterList(String type);
    /**
     * LiveData
     */
    @Query("select * from SecHunterEntity where type = :type")
    LiveData<List<SecHunterEntity>> getSecHunter(String type);
}
