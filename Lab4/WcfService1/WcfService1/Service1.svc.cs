using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace WcfService1
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class Service1 : IService1
    {
        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "add/{x}/{y}")]

        public string add(string x, string y)
        {
            int a = Convert.ToInt32(x);
            int b = Convert.ToInt32(y);
            return Convert.ToString(a + b);
        }

        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "multiply/{x}/{y}")]

        public string multiply(string x, string y)
        {
            int a = Convert.ToInt32(x);
            int b = Convert.ToInt32(y);
            return Convert.ToString(a * b);
        }

        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "subtract/{x}/{y}")]

        public string subtract(string x, string y)
        {
            int a = Convert.ToInt32(x);
            int b = Convert.ToInt32(y);
            return Convert.ToString(a - b);
        }

        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "divide/{x}/{y}")]

        public string divide(string x, string y)
        {
            int a = Convert.ToInt32(x);
            int b = Convert.ToInt32(y);
            return Convert.ToString(a / b);
        }
    }
}
