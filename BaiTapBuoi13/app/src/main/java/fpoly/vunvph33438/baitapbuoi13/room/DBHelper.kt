package fpoly.vunvph33438.baitapbuoi13.room

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Database(entities = [StudentModel::class], version = 1, exportSchema = false)
abstract class StudentDB : RoomDatabase() {
    abstract fun studentDAO(): StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: StudentDB? = null

        fun getInstance(context: Context): StudentDB {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDB::class.java,
                        "student_db"
                    ).build()
                }
                return instance
            }
        }
    }
}

@Dao
interface StudentDAO {
    @Query("SELECT * FROM Student")
    fun getAll(): Flow<List<StudentModel>>

    @Insert
    suspend fun insert(studentModel: StudentModel)

    @Delete
    suspend fun delete(studentModel: StudentModel)

    @Update
    suspend fun update(studentModel: StudentModel)
}