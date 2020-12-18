/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

package com.aligmohammad.doctorapp.util

import java.io.IOException

/**
 * A class for custom Api Exceptions
 * @constructor
 */
class ApiException(message: String) : IOException(message)

/**
 *  A class for custom NoInternet Exceptions
 * @constructor
 */
class NoInternetException(message: String): IOException(message)

class NetworkException(message: String): IOException(message)