<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:Label ID="Label1" runat="server" Text="Math Calculations"></asp:Label>
        <p>
            <asp:Label ID="Label2" runat="server" Text="Number1"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" OnTextChanged="TextBox1_TextChanged" style="margin-top: 0px"></asp:TextBox>
        </p>
        <asp:Label ID="Label4" runat="server" Text="Number2"></asp:Label>
        <asp:TextBox ID="TextBox2" runat="server" OnTextChanged="TextBox2_TextChanged"></asp:TextBox>
        <p>
            <asp:Label ID="Label3" runat="server" Text="Result"></asp:Label>
            <asp:TextBox ID="TextBox3" runat="server" OnTextChanged="TextBox3_TextChanged"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click1" Text="ADD" />
            <asp:Button ID="Button2" runat="server" OnClick="Button2_Click1" Text="SUB" />
            <asp:Button ID="Button3" runat="server" OnClick="Button3_Click1" Text="MUL" />
            <asp:Button ID="Button4" runat="server" OnClick="Button4_Click1" Text="DIV" />
        </p>
    </form>
</body>
</html>
