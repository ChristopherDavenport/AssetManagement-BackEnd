package dao

import models.Printer

import java.sql.Date
import slick.driver.PostgresDriver.api._
import javax.inject.{Singleton, Inject}
import scala.concurrent.Future
import play.api.db.slick.{HasDatabaseConfigProvider, DatabaseConfigProvider}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile


/**
  * Created by chris on 3/12/16.
  */

@Singleton
class PrinterSchema @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) {
  self: HasDatabaseConfigProvider[JdbcProfile] =>
  import driver.api._

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


  def resultingPrinters(): Future[Seq[Printer]] = dbConfig.db.run(Printers.result)

  def count(): Future[Int] = {
    db.run(Printers.length.result)
  }

}
