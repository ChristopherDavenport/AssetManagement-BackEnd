package controllers

import javax.inject._
import play.api.Play
import slick.driver.JdbcProfile
import dao.PrinterSchema


import play.api.mvc._
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.ExecutionContext


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MyController @Inject() (printerSchema:PrinterSchema)(implicit exec: ExecutionContext) extends Controller {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index =  Action { implicit request =>

    val myString = printerSchema.toString
    Ok(myString)
  }

}
