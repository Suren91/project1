using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void TextBox1_TextChanged(object sender, EventArgs e)
    {

    }
    protected void TextBox2_TextChanged(object sender, EventArgs e)
    {

    }
    protected void TextBox3_TextChanged(object sender, EventArgs e)
    {

    }
     

    protected void Button1_Click1(object sender, EventArgs e)
    {
        WebReference.WebService1 web = new WebReference.WebService1();
        int result = web.add(Convert.ToInt32(TextBox1.Text), Convert.ToInt32(TextBox2.Text));
        TextBox3.Text = Convert.ToString(result);
    }
    protected void Button2_Click1(object sender, EventArgs e)
    {
        WebReference.WebService1 web = new WebReference.WebService1();
        int result = web.sub(Convert.ToInt32(TextBox1.Text), Convert.ToInt32(TextBox2.Text));
        TextBox3.Text = Convert.ToString(result);
    }
    protected void Button3_Click1(object sender, EventArgs e)
    {
        WebReference.WebService1 web = new WebReference.WebService1();
        int result = web.multiply(Convert.ToInt32(TextBox1.Text), Convert.ToInt32(TextBox2.Text));
        TextBox3.Text = Convert.ToString(result);
    }
    protected void Button4_Click1(object sender, EventArgs e)
    {
        WebReference.WebService1 web = new WebReference.WebService1();
        int result = web.div(Convert.ToInt32(TextBox1.Text), Convert.ToInt32(TextBox2.Text));
        TextBox3.Text = Convert.ToString(result);
    }
}