package fpoly.vunvph33438.baitapbuoi13.repository

import fpoly.vunvph33438.baitapbuoi13.room.StudentDB
import fpoly.vunvph33438.baitapbuoi13.room.StudentModel

class Repository(val studentDB: StudentDB) {
    suspend fun addStudentToRoom(studentModel: StudentModel) {
        studentDB.studentDAO().insert(studentModel)
    }

    fun getAll() = studentDB.studentDAO().getAll()

    suspend fun deleteStudentFromRoom(studentModel: StudentModel) {
        studentDB.studentDAO().delete(studentModel)
    }

    suspend fun updateStudent(studentModel: StudentModel) {
        studentDB.studentDAO().update(studentModel)
    }
}