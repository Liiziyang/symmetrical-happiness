import view.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            GameFrame mainFrame = new GameFrame(800);
            mainFrame.setVisible(true);
        });
    }
}
/*黑白棋规则√
1.music√
2.悔棋√
3.存储与读取
4.翻棋动作
5.标记可以下棋的位置
6.人机√
7.输赢的判断及动画√
8.存储账户与密码


 */