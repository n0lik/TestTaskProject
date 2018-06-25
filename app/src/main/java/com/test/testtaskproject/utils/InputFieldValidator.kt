package com.test.testtaskproject.utils

import com.test.testtaskproject.R
import java.util.regex.Pattern

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
private const val MIN_PSWRD_LENGTH = 4
private const val MAX_PSWRD_LENGTH = 10

class InputFieldValidator private constructor() {

    companion object {

        private val emailRegExp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[" +
                "\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c" +
                "\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
                "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|" +
                "[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"


        /**
         * Return
         * @null                    -  if email valid
         * @IdRes for alert message -  if invalid
         */

        fun checkEmailValid(emailStr: String?): Int? {
            if(emailStr.isNullOrEmpty()) {
                return R.string.alert_empty_email
            } else if(!isEmailValid(emailStr!!)) {
                return R.string.alert_incorrect_email
            } else {
                return null
            }
        }

        private fun isEmailValid(email: String): Boolean {
            return Pattern.compile(emailRegExp, Pattern.CASE_INSENSITIVE).matcher(email).matches()
        }

        fun checkPasswordValid(password: String?): Int? {
            if(password.isNullOrEmpty()) return R.string.alert_pswrd_empty
            return if(password!!.length in MIN_PSWRD_LENGTH..MAX_PSWRD_LENGTH)
                return null else R.string.alert_pswrd_lower
        }

    }

}