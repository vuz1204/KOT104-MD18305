package fpoly.vunvph33438.baitapbuoi13.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fpoly.vunvph33438.baitapbuoi13.repository.Repository
import fpoly.vunvph33438.baitapbuoi13.room.StudentModel
import kotlinx.coroutines.launch

class StudentViewModel(val repository: Repository): ViewModel() {
    fun addStudent(student: StudentModel) {
        viewModelScope.launch {
            repository.addStudentToRoom(student)
        }
    }

    val students = repository.getAll()

    fun deleteStudent(student: StudentModel) {
        viewModelScope.launch {
            repository.deleteStudentFromRoom(student)
        }
    }

    fun updateStudent(student: StudentModel) {
        viewModelScope.launch {
            repository.updateStudent(student)
        }
    }
}