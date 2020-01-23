import javax.swing._
import java.awt.event._

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test14 {
  def main(args: Array[String]): Unit = {
    val button = new JButton("click")
    button.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        println("Click Me!!!")
      }
    })

    implicit def getActionListener(actionProcessFunc: ActionEvent => Unit) = new ActionListener {
      override def actionPerformed(event: ActionEvent): Unit = {
        actionProcessFunc(event)
      }
    }

    button.addActionListener((event: ActionEvent) => println("click me!"))


  }
}
