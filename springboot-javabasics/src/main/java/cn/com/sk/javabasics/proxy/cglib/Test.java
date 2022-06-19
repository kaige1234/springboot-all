package cn.com.sk.javabasics.proxy.cglib;

public class Test {
    public static void  main(String[] args){
        CglibProxy cglibProxy = new CglibProxy();
        PlayGame playGame = (PlayGame)cglibProxy.newInstall(new PlayGame());
        playGame.play();
    }
}
