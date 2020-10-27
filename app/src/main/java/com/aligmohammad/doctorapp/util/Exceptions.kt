package com.aligmohammad.doctorapp.util

import java.io.IOException

/**
 * A class for custom Api Exceptions
 * @constructor
 */
class ApiException(message: String) :  IOException(message)

/**
 *  A class for custom NoInternet Exceptions
 * @constructor
 */
class NoInternetException(message: String): IOException(message)