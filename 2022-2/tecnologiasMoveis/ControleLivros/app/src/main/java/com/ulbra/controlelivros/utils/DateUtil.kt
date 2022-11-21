package com.ulbra.controlelivros.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.EditText
import android.widget.TimePicker
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun dataFormat(aFormato: String, aData: Date): String {
        return data(aFormato, aData)
    }

    fun data(aData: Date): String {
        return data("dd/MM/yyyy HH:mm:ss", aData)
    }

    @SuppressLint("SimpleDateFormat")
    fun data(aFormato: String, aDate: String?): String {
        val parse = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(aDate)
        return data(aFormato, parse)
    }

    @SuppressLint("SimpleDateFormat")
    fun dataPayment(aFormato: String, aDate: String?): String {
        if(aDate!!.contains("/")) {
            return dataPaymentII(aFormato, aDate)
        }
        val parse = SimpleDateFormat("yyyy-MM-dd").parse(aDate)
        return data(aFormato, parse)
    }

    @SuppressLint("SimpleDateFormat")
    fun dataPaymentToDate(aFormato: String, aDate: String?): Date {
        if(aDate!!.contains("/")) {
            return SimpleDateFormat("dd/MM/yyyy").parse(aDate)
        }
        val parse = SimpleDateFormat("yyyy-MM-dd").parse(aDate)
        return parse
    }

    fun dataPaymentII(aFormato: String, aDate: String?): String {
        val parse = SimpleDateFormat("dd/MM/yyyy").parse(aDate)
        return data(aFormato, parse)
    }

    fun dataToDate(formato : String, aData: String): Date {
        return SimpleDateFormat(formato).parse(aData)
    }

    fun data(aFormato: String, aDate: String?, aFormatoString : String?): String {
        val parse = SimpleDateFormat(aFormatoString).parse(aDate)
        return data(aFormato, parse)
    }

    fun data(aData: String): Date {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(aData)
    }

    fun data(aData: String, formarto : String): Date {
        return SimpleDateFormat(formarto).parse(aData)
    }

    @SuppressLint("SimpleDateFormat")
    fun data(aFormato: String, aData: Date?): String {
        return if (aData != null) SimpleDateFormat(aFormato).format(aData) else ""
    }

    fun data(aData: Date, aFormato: String): String {
        return data(aFormato, aData)
    }

    fun dataAtual(aFormato: String): String {
        return SimpleDateFormat(aFormato).format(Date())
    }

    fun addDaysAtualDate(aFormato: String, daysAdd : Int): String {
        var calendar : Calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, daysAdd)
        return SimpleDateFormat(aFormato).format(calendar.time)
    }

    fun getLastDayMonth(aCurrentMonth: Calendar): Calendar {
        val lMaxCalendar = aCurrentMonth.clone() as Calendar
        lMaxCalendar.set(
            Calendar.DAY_OF_MONTH,
            aCurrentMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        )
        lMaxCalendar.set(Calendar.HOUR_OF_DAY, 23)
        lMaxCalendar.set(Calendar.MINUTE, 59)
        lMaxCalendar.set(Calendar.SECOND, 59)
        lMaxCalendar.set(Calendar.MILLISECOND, 999)
        return lMaxCalendar
    }

    fun getFirstDayMonth(aCurrentMonth: Calendar): Calendar {
        val lMinCalendar = aCurrentMonth.clone() as Calendar
        lMinCalendar.set(
            Calendar.DAY_OF_MONTH,
            aCurrentMonth.getActualMinimum(Calendar.DAY_OF_MONTH)
        )
        lMinCalendar.set(Calendar.HOUR_OF_DAY, 0)
        lMinCalendar.set(Calendar.MINUTE, 0)
        lMinCalendar.set(Calendar.SECOND, 0)
        lMinCalendar.set(Calendar.MILLISECOND, 0)
        return lMinCalendar
    }

    fun showDatePicker(context: Context, calendar: Calendar, editText: EditText, maxDate: Long?, minDate: Long?) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(context, { _, _year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.YEAR, _year)
            editText.setText(data("dd/MM/yyyy HH:mm", calendar.time))
            showTimePicker(context, calendar, editText)
        }, year, month, day)
        minDate?.let { dpd.datePicker.minDate = it }
        maxDate?.let { dpd.datePicker.maxDate = it }
        dpd.show()
    }

    private fun showTimePicker(context: Context, calendar: Calendar, editText: EditText) {
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        TimePickerDialog(
            context,
            { _: TimePicker?, hour: Int, _minute: Int ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, _minute)
                editText.setText(data("dd/MM/yyyy HH:mm", calendar.time))
            },
            hourOfDay,
            minute,
            true
        ).show()
    }
}