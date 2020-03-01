package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class StatisticsUtilsTest{

       //If there is no completed task then return 0%
      // if one active task return 100%
    @Test
       fun getActiveAndCompleteStats_noCompleted_returnZeroHundred(){
            val task = listOf<Task>(
                    Task("Title","DESC", isCompleted = false)
            )
              val result = getActiveAndCompletedStats(task)
           assertThat(result.completedTasksPercent ,`is` (0f))
           assertThat(result.activeTasksPercent, `is` (100f))
       }
    // test for active and complete task
    @Test
    fun getActiveAndCompleteStats_both_returnFortySixty(){
        val task = listOf<Task>(
                Task("Title","DESC", isCompleted = true),
                Task("Title","DESC", isCompleted = true),
                Task("Title","DESC", isCompleted = false),
                Task("Title","DESC", isCompleted = false),
                Task("Title","DESC", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent ,`is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    //list is empty then return 0% complete and 0% active
    @Test
    fun getActiveAndCompleteStats_taskEmpty_returnZeroZero(){
        val task = emptyList<Task>()
        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))
    }

    @Test
    fun getActiveAndCompleteStats_null_returnZeroZero(){
        val task = null
        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))
    }
}