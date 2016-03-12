package dao

import models.Printer
import slick.lifted.{TableQuery, Tag}

import java.sql.Date
import slick.driver.PostgresDriver.api._


/**
  * Created by chris on 3/12/16.
  */
object PrinterSchema {
  class Printers(tag: Tag) extends Table[Printer](tag, "Printers"){
    def printer_pk = column[String]("printer_pk", O.PrimaryKey)
    def printer_desc = column[String]("printer_desc")
    def status_ck = column[String]("status_ck")
    def status_date = column[Option[Date]]("status_date")
    def activity_date = column[Option[Date]]("activity_date")
    def user_id = column[Option[String]]("user_id")

    def * = (printer_pk, printer_desc, status_ck, status_date , activity_date , user_id ) <> (Printer.tupled, Printer.unapply _)
  }
  val Printers = TableQuery[Printers]
}
