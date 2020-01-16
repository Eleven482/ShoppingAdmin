# ShoppingAdmin
### 添加商品和修改商品信息后图片无法正常显示的错误已经改正，是因为在GoodServlet文件中用的是写死的图片文件（为了方便），可以完善
### 文件夹里的.sql文件需要用操作数据库的软件打开后导入
### 如果缺少jar包，可到这个网址按字母序搜索下载http://www.java2s.com/example/jar/jar.html
# 一、Mystore工程
## （一）jsp页面
1.detail.jsp页面中的支付弹出页面需要完善，函数在18行，调用在60行

2.footer.jsp页面是所有页面公用的，其他jsp文件通过在body的末尾使用引入代码<%@ include file="/footer.jsp"%>  调用footer.jsp

3.goods_car页面，没有链接，可以在主页添加按钮调用这个页面（页面没写东西）

4.goods_list页面，被主页的横向导航栏调用，根据不同的分类名称显示不同的内容，调用过程：index.jsp --> GoodsServlet.java(第50行) --> goods_list.jsp
5.header.jsp页面, 第65-69行的推荐搜索内容没有链接到其他页面，是在主页搜索栏下面的五个小词语；第82-87行是各大分类的调用，不同的分类显示不同的商品，这些商品可以根据后台商品数据的更新动态的更新

6.index.jsp页面是登陆后的首页，第15行是轮播图的实现，调用lunbotu.jsp， 第18-98行的商品显示是写死的，不是动态更新的

7.login.jsp页面， 登录按钮旁边的忘记密码、忘记会员名两个键是不能用的，没有外部链接，免费注册能用，可以跳转到注册页面

8.lunbotu.jsp页面， 实现首页轮播图

9.pay.jsp页面，同goods_car.jsp

10.regist.jsp页面，第24行的‘请登录’按钮可以跳转到登录页面，67-99行是注册过程的正确性检查，要是需要改进的话好像可以用正则表达式

11.user_info_edit.jsp页面，是修改个人信息的页面，提交form表单就行了，方法在69行实现

12.user_info.jsp页面，用户信息的显示页面，很简陋很简陋。第55-60行的代码是实现把用户的信息写到页面上，这个方法比较笨，应该有写起来更好看的方法

## （二）java代码--- springMVC三成架构 （Servlet层--Service层--Dao层）

1..dao是Dao层，被Service的方法调用，进而调用一些数据库命令，对数据库中的表进行操作

2.domain是商品、用户两种类的属性的定义，包括各种属性的定义

3.service是Service层，被Servlet层的方法调用，进而调用Dao层

4.servlet是Servlet层，被各个jsp页面中的各种请求调用（里面的文件最多也比较复杂），进而调用service层

5.dbproperties文件是数据库的链接配置文件，链接数据库之前，需要在这个文件里把使用的数据库的名字和用户名密码都需要从这里写好，才能正常连接

# 二、MystoreAdmin工程
## （一）jsp页面
1.accoun.jsp，添加管理员的操作和添加商品类似，没具体再写，弹出框都做好了，只剩把添加的管理员信息回显到管理员管理页面了，如果不需要的话可以把这个页面隐藏掉

2.add.jsp， 添加商品的页面， 方法定义在81行，26-72行就是整体提交的form表单，直接调用对应的servlet里的方法

3.admin_index.jsp, 管理员登陆后的首页， 由top.jsp（第28行引入） 、 left.jsp（第32行引入） 、和最后34行调用了GoodsServlet之后跳转到的main.jsp三部分页面组成

4.admin_login.jsp, 管理员登录页面，调用AdminServlet，一层层的调用下去查询数据库中的admin表中是否有相应的登录名密码

5.category.jsp， 分类管理页面，同account页面，这个不建议再添加分类了，添加之后前端的横向导航栏又需要修改

6.edit.jsp，和前端的user_info_edit.jsp页面一样

7.left.jsp，左侧导航栏，被admin_index.jsp页面调用作为组成部分，可以链接到分类管理页面、商品管理页面、用户管理页面

8.main.jsp, 被admin_index.jsp页面调用作为组成部分，是后台对数据库中的商品进行操作的主要页面，能实现增删改，不能查询

9.top.jsp, 被admin_index.jsp页面调用作为组成部分，能够显示已经登录的管理员账号

## （二）java代码 --- springMVC三成架构 （Servlet层--Service层--Dao层）
同Mystore工程，只是在Servlet层进行了优化
