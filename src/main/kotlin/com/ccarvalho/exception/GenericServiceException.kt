package com.ccarvalho.exception

class GenericServiceException: Exception {

    constructor(): super()

    constructor(resourceId: String, cause: Throwable): super(resourceId, cause)

    constructor(resourceId: String): super(resourceId)

    constructor(cause: Throwable): super(cause)
}