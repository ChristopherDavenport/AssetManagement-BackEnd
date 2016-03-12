package models

import java.time.LocalDate
import play.api.libs.json.JsValue

import java.sql.Date
import play.api.Play.current
import play.api.db.DB
import slick.driver.PostgresDriver._
import slick.lifted.Tag

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

class Printers(tag: Tag) extends Table[Printer](tag, "Printers"){
  def printer_pk = column[String]("printer_pk", O.PrimaryKey)
  def printer_desc = column[String]("printer_desc")
  def status_ck = column[String]("status_ck")
  def status_date = column[Option[Date]]("status_date")
  def activity_date = column[Option[Date]]("activity_date")
  def user_id = column[Option[String]]("user_id")

  def * = (printer_pk, printer_desc, status_ck, status_date.? , activity_date.? , user_id.?) <> (Printer.tupled, Printer.unapply _)
}
