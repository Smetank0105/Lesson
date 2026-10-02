import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

void main() {
    //1
//    JFrame input = new JFrame();
//    input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    input.setSize(300,200);
//    input.setLayout(new GridLayout(4,2,10,10));
//
//    Random random = new Random();
//
//    input.add(new JLabel("От"));
//    JTextField from = new JPasswordField();
//    input.add(from);
//    input.add(new JLabel("До"));
//    JTextField to = new JPasswordField();
//    input.add(to);
//    JButton btn = new JButton("Generate");
//    input.add(btn);
//    JLabel result = new JLabel("");
//    input.add(result);
//
//    btn.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String fromText = from.getText().trim();
//            String toText = to.getText().trim();
//
//            try {
//                int from = Integer.parseInt(fromText);
//                int to = Integer.parseInt(toText);
//
//                if (from > to) {
//                    result.setText("Ошибка: 'от' больше 'до'");
//                    return;
//                }
//
//                int randomNumber = random.nextInt(to - from + 1) + from;
//                result.setText(String.valueOf(randomNumber));
//            } catch (NumberFormatException ex) {
//                result.setText("Ошибка: введите целые числа");
//            }
//        }
//    });
//    input.setVisible(true);

    //2
    int[] count = {0};

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setSize(300,200);

    JLabel label = new JLabel("Кликов 0");
    JButton clicker = new JButton("Клик");
    JButton reset = new JButton("Сброс");
    frame.add(label);
    frame.add(clicker);
    frame.add(reset);

    clicker.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count[0]++;
            if (count[0] >= 10) {
                label.setText("Хватит кликать!");
                clicker.setEnabled(false);
            } else {
                label.setText("Кликов: " + count[0]);
            }
        }
    });

    reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count[0] = 0;
            label.setText("Кликов: 0");
            clicker.setEnabled(true);
        }
    });

    frame.setVisible(true);
}
