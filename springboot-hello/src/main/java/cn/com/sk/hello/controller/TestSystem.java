package cn.com.sk.hello.controller;

/**
 * @author sunkai
 * @title: TestSystem
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/1910:58
 */
public class TestSystem {
    //Java提供了System类的静态方法getenv()和getProperty()用于返回系统相关的变量与属性，getenv方法返回的变量大多于系统相关，getProperty方法返回的变量大多与java程序有关。
    //System.getenv() 方法是获取指定的环境变量的值。
    //System.getenv(String str) 接收参数为任意字符串，当存在指定环境变量时即返回环境变量的值，否则返回null。
    //System.getProperty() 是获取系统的相关属性，包括文件编码、操作系统名称、区域、用户名等，此属性一般由jvm自动获取，不能设置。
    //System.getProperty(String str) 接收参数为任意字符串，当存在指定属性时即返回属性的值，否则返回null。
    //System.getenv()

   /* USERPROFILE        ：用户目录
    USERDNSDOMAIN      ：用户域
    PATHEXT            ：可执行后缀
    JAVA_HOME          ：Java安装目录
    TEMP               ：用户临时文件目录
    SystemDrive        ：系统盘符
    ProgramFiles       ：默认程序目录
    USERDOMAIN         ：帐户的域的名称
    ALLUSERSPROFILE    ：用户公共目录
    SESSIONNAME        ：Session名称
    TMP                ：临时目录
    Path               ：path环境变量
    CLASSPATH          ：classpath环境变量
    PROCESSOR_ARCHITECTURE ：处理器体系结构
    OS                     ：操作系统类型
    PROCESSOR_LEVEL    ：处理级别
    COMPUTERNAME       ：计算机名
    Windir             ：系统安装目录
    SystemRoot         ：系统启动目录
    USERNAME           ：用户名
    ComSpec            ：命令行解释器可执行程序的准确路径
    APPDATA            ：应用程序数据目录*/

   /*System.getProperty()

    java.version Java ：运行时环境版本
    java.vendor Java ：运行时环境供应商
    java.vendor.url ：Java供应商的 URL
    java.home   ：Java安装目录
    java.vm.specification.version： Java虚拟机规范版本
    java.vm.specification.vendor ：Java虚拟机规范供应商
    java.vm.specification.name   ：Java虚拟机规范名称
    java.vm.version ：Java虚拟机实现版本
    java.vm.vendor ：Java虚拟机实现供应商
    java.vm.name  ：Java虚拟机实现名称
    java.specification.version：Java运行时环境规范版本
    java.specification.vendor：Java运行时环境规范供应商
    java.specification.name ：Java运行时环境规范名称
    java.class.version ：Java类格式版本号
    java.class.path ：Java类路径
    java.library.path  ：加载库时搜索的路径列表
    java.io.tmpdir  ：默认的临时文件路径
    java.compiler  ：要使用的 JIT编译器的名称
    java.ext.dirs ：一个或多个扩展目录的路径
    os.name ：操作系统的名称
    os.arch  ：操作系统的架构
    os.version  ：操作系统的版本
    file.separator ：文件分隔符
    path.separator ：路径分隔符
    line.separator ：行分隔符
    user.name ：用户的账户名称
    user.home ：用户的主目录
    user.dir：用户的当前工作目录*/
    public static void testSystemGetenv(){
        String java_home = System.getenv("JAVA_HOME");
        System.out.println(java_home);

        System.out.println("===========================");
        String user_dir = System.getProperty("user.dir");
        System.out.println(user_dir);
    }

    public static void main(String[] args){
        TestSystem.testSystemGetenv();
    }
}
