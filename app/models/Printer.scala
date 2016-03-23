package models

import java.sql.Date

import play.api.libs.json.Json


/**
  * Created by chris on 3/12/16.
  */
case class Printer (
                     printer_pk: String,
                     printer_desc: String,
                     status_ck: String,
                     status_date: Option[Date] = None,
                     activity_date: Option[Date]= None,
                     user_id: Option[String] = None
                   )
object Printer{
  implicit val recordWrites = Json.writes[Printer]
}
