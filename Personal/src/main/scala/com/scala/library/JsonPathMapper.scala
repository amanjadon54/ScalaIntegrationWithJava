package com.scala.library

import com.fasterxml.jackson.databind.ObjectMapper
import io.gatling.jsonpath.JsonPath
import scala.collection.JavaConverters._;

object JsonPathMapper {

  def mapper(jsonResponse: String, query: String): String = try {

    val mapper = new ObjectMapper();

    val jsonResponseMapped = mapper.readValue(jsonResponse, classOf[Object])
    val result = JsonPath.query(query, jsonResponseMapped);
    val line = result.right.map(_.toVector);

    line match {
      //when it is a right value, which is a vector with single element
      case Right(Vector(s)) => s.toString

      //when it is a right value, which is a vector with wmpty or 2 or more elements
      case Right(v) => mapper.writeValueAsString(v.toList.asJava)

      //when it is a left value
      case Left(l) => ???
    }
  }
  catch {
    case e => null
  }
}
