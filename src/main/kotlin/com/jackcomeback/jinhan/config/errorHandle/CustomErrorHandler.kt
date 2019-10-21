package com.jackcomeback.jinhan.config.errorHandle


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class CustomErrorHandler(@Autowired errorAttributes: ErrorAttributes) : AbstractErrorController(errorAttributes) {

    @RequestMapping(value="/error", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun handleError(request: HttpServletRequest) : Map<String, Any>{

        return super.getErrorAttributes(request,false)
    }
    override fun getErrorPath(): String {
        return "/error"
    }
}