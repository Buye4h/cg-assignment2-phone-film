import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

//63050147 Tharita Watanapa sec1
//63050166 Pilada Prasan sec2

public class Assignment2_63050147_63050166 {

    static class GraphicsSwing extends JPanel implements Runnable {

        double circleMove = 0.0;

        double velocityY = 120;

        double width = 600;
        double total_time = 0.0;

        // wave_0 D R //center
        double wavey_0 = 312; // y
        double wavex_01 = 305; // x
        // wave_1 L
        double wavex_1 = 280;
        double wavey_11 = 324;
        // wave_2 D L
        double wavex_2 = 320;
        double wavey_21 = 330;
        // wave_3 R
        double wavex_3 = 305;
        double wavey_31 = 336;
        // wave_4 L
        double wavex_4 = 315;
        double wavey_41 = 340;
        // wave_5 D L
        double wavex_5 = 360;
        double wavey_51 = 345;
        // wave_6 L
        double wavex_6 = 310;
        double wavey_61 = 350;
        // wave_7 L
        double wavex_7 = 340;
        double wavey_71 = 359;

        // wave_8 U R
        double wavex_8 = 320;
        double wavey_81 = 375;

        // wave_9 U L
        double wavex_9 = 316;
        double wavey_91 = 378;

        // wave_10 R
        double wavex_10 = 300;
        double wavey_101 = 378;

        // wave_11 U L
        double wavex_11 = 250;
        double wavey_111 = 378;

        // wave_12 U R
        double wavex_12 = 233;
        double wavey_121 = 386;

        // wave_13 U R
        double wavex_13 = 288;
        double wavey_131 = 394;

        // wave_14 R
        double wavex_14 = 370;
        double wavey_141 = 372;

        // wave_15 U L
        double wavex_15 = 395;
        double wavey_151 = 369;

        // wave_16 R
        double wavex_16 = 365;
        double wavey_161 = 383;

        // wave_17 U L
        double wavex_17 = 357;
        double wavey_171 = 394;

        // wave_18 R
        double wavex_18 = 310;
        double wavey_181 = 400;

        // wave_19 U R
        double wavex_19 = 250;
        double wavey_191 = 402;

        // wave_20 R
        double wavex_20 = 270;
        double wavey_201 = 410;

        // wave_21 R
        double wavex_21 = 260;
        double wavey_211 = 417;

        // wave_22 L
        double wavex_22 = 280;
        double wavey_221 = 425;

        // wave_23 R
        double wavex_23 = 160;
        double wavey_231 = 415;

        // wave_24 R
        double wavex_24 = 285;
        double wavey_241 = 430;

        // wave_25 R
        double wavex_25 = 350;
        double wavey_251 = 421;

        // wave_26 R
        double wavex_26 = 383;
        double wavey_261 = 438;

        // wave_27 R
        double wavex_27 = 285;
        double wavey_271 = 442;

        // wave_28 R
        double wavex_28 = 278;
        double wavey_281 = 448;

        // wave_29 R
        double wavex_29 = 268;
        double wavey_291 = 456;

        // wave_30 U R
        double wavex_30 = 290;
        double wavey_301 = 463;

        // wave_31 U L
        double wavex_31 = 290;
        double wavey_311 = 473;

        // wave_32 L
        double wavex_32 = 400;
        double wavey_321 = 479;

        // wave_33 U R
        double wavex_33 = 273;
        double wavey_331 = 495;

        // wave_34 U L
        double wavex_34 = 325;
        double wavey_341 = 510;

        // wave_35 R
        double wavex_35 = 280;
        double wavey_351 = 512;

        // wave_36 U L
        double wavex_36 = 330;
        double wavey_361 = 518;

        // wave_37 R
        double wavex_37 = 325;
        double wavey_371 = 528;

        // wave_38 R
        double wavex_38 = 300;
        double wavey_381 = 550;

        // wave_39 R
        double wavex_39 = 289;
        double wavey_391 = 557;

        // wave_40 R
        double wavex_40 = 286;
        double wavey_401 = 564;

        public static void main(String[] args) {

            GraphicsSwing m = new GraphicsSwing();
            // create window
            JFrame f = new JFrame();
            f.add(m);
            f.setTitle("It's time to say good bye");
            f.setSize(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            // Thread
            Thread.currentThread().setPriority((int) (Thread.MAX_PRIORITY * 0.8));
            (new Thread(m)).start();

        }

        public void run() {

            double lastTime = System.currentTimeMillis();
            double currentTime, elapsedTime;

            while (true) {
                // control time
                // currentTime = System.currentTimeMillis();
                currentTime = System.currentTimeMillis();
                elapsedTime = currentTime - lastTime;
                lastTime = currentTime;

                // update

                circleMove += 2.0 * elapsedTime / 1000.0;
                if (circleMove > 66) {
                    circleMove = 0;
                }

                // velocity SUN
                velocityY += 7.0 * elapsedTime / 1000.0;
                if (velocityY > 350) {
                    velocityY = 120;
                }

                // WAVE------------------------------------------------------------------
                // wave_0
                wavey_0 += 5 * elapsedTime / 1000.0;
                wavex_01 += 5 * elapsedTime / 1000.0;
                if (wavey_0 > 320 && wavex_01 > 314) {
                    wavey_0 = 312;
                    wavex_01 = 307;
                }
                // wave_1
                wavex_1 -= 7 * elapsedTime / 1000.0;
                if (wavex_1 < 268) {
                    wavex_1 = 280;
                }

                // wave_2
                wavex_2 -= 7 * elapsedTime / 1000.0;
                wavey_21 += 7 * elapsedTime / 1000.0;
                if (wavex_2 < 315 && wavey_21 > 332) {
                    wavex_2 = 320;
                    wavey_21 = 330;
                }

                // wave_3
                wavex_3 += 7 * elapsedTime / 1000.0;
                if (wavex_3 > 325) {
                    wavex_3 = 305;
                }

                // wave_4
                wavex_4 -= 7 * elapsedTime / 1000.0;
                if (wavex_4 < 305) {
                    wavex_4 = 315;
                }

                // wave_5
                wavex_5 -= 7 * elapsedTime / 1000.0;
                wavey_51 += 7 * elapsedTime / 1000.0;
                if (wavex_5 < 350 && wavey_51 > 347) {
                    wavex_5 = 360;
                    wavey_51 = 345;
                }
                // wave_6
                wavex_6 -= 7 * elapsedTime / 1000.0;
                if (wavex_6 < 300) {
                    wavex_6 = 310;
                }

                // wave_7
                wavex_7 -= 7 * elapsedTime / 1000.0;
                if (wavex_7 < 330) {
                    wavex_7 = 340;
                }

                // wave_8
                wavex_8 += 7 * elapsedTime / 1000.0;
                wavey_81 -= 7 * elapsedTime / 1000.0;
                if (wavex_8 > 330 && wavey_81 < 372) {
                    wavex_8 = 320;
                    wavey_81 = 375;
                }

                // wave_9
                wavex_9 -= 5 * elapsedTime / 1000.0;
                wavey_91 -= 5 * elapsedTime / 1000.0;
                if (wavex_9 < 312 && wavey_91 < 373) {
                    wavex_9 = 316;
                    wavey_91 = 378;
                }

                // wave_10
                wavex_10 += 7 * elapsedTime / 1000.0;
                if (wavex_10 > 340) {
                    wavex_10 = 310;
                }

                // wave_11
                wavex_11 -= 7 * elapsedTime / 1000.0;
                wavey_111 -= 7 * elapsedTime / 1000.0;
                if (wavex_11 < 245 && wavey_111 < 373) {
                    wavex_11 = 255;
                    wavey_111 = 378;
                }

                // wave_12
                wavex_12 += 7 * elapsedTime / 1000.0;
                wavey_121 -= 7 * elapsedTime / 1000.0;
                if (wavex_12 > 245 && wavey_121 < 383) {
                    wavex_12 = 231;
                    wavey_121 = 386;
                }

                // wave_13
                wavex_13 += 7 * elapsedTime / 1000.0;
                wavey_131 -= 7 * elapsedTime / 1000.0;
                if (wavex_13 > 290 && wavey_131 < 385) {
                    wavex_13 = 288;
                    wavey_131 = 394;
                }

                // wave_14

                wavex_14 += 7 * elapsedTime / 1000.0;
                if (wavex_14 > 375) {
                    wavex_14 = 370;
                }

                // wave_15
                wavex_15 -= 7 * elapsedTime / 1000.0;
                wavey_151 -= 7 * elapsedTime / 1000.0;
                if (wavex_15 < 384 && wavey_151 < 367) {
                    wavex_15 = 395;
                    wavey_151 = 369;
                }

                // wave_16

                wavex_16 += 7 * elapsedTime / 1000.0;
                if (wavex_16 > 375) {
                    wavex_16 = 365;
                }

                // wave_17
                wavex_17 -= 5 * elapsedTime / 1000.0;
                wavey_171 -= 5 * elapsedTime / 1000.0;
                if (wavex_17 < 354 && wavey_171 < 388) {
                    wavex_17 = 357;
                    wavey_171 = 394;
                }

                // wave_18

                wavex_18 += 7 * elapsedTime / 1000.0;
                if (wavex_18 > 330) {
                    wavex_18 = 310;
                }

                // wave_19
                wavex_19 -= 5 * elapsedTime / 1000.0;
                wavey_191 -= 5 * elapsedTime / 1000.0;
                if (wavex_19 < 245 && wavey_191 < 398) {
                    wavex_19 = 250;
                    wavey_191 = 402;
                }

                // wave_20

                wavex_20 += 7 * elapsedTime / 1000.0;
                if (wavex_20 > 295) {
                    wavex_20 = 270;
                }

                // wave_21

                wavex_21 += 5 * elapsedTime / 1000.0;
                if (wavex_21 > 275) {
                    wavex_21 = 260;
                }

                // wave_22

                wavex_22 -= 5 * elapsedTime / 1000.0;
                if (wavex_22 < 265) {
                    wavex_22 = 280;
                }

                // wave_23

                wavex_23 += 5 * elapsedTime / 1000.0;
                if (wavex_23 > 180) {
                    wavex_23 = 160;
                }

                // wave_24

                wavex_24 += 5 * elapsedTime / 1000.0;
                if (wavex_24 > 295) {
                    wavex_24 = 285;
                }

                // wave_25

                wavex_25 -= 5 * elapsedTime / 1000.0;
                if (wavex_25 < 345) {
                    wavex_25 = 350;
                }

                // wave_26

                wavex_26 -= 5 * elapsedTime / 1000.0;
                if (wavex_26 < 378) {
                    wavex_26 = 383;
                }

                // wave_27

                wavex_27 += 5 * elapsedTime / 1000.0;
                if (wavex_27 > 292) {
                    wavex_27 = 285;
                }

                // wave_28

                wavex_28 += 5 * elapsedTime / 1000.0;
                if (wavex_28 > 285) {
                    wavex_28 = 278;
                }

                // wave_29

                wavex_29 += 5 * elapsedTime / 1000.0;
                if (wavex_29 > 275) {
                    wavex_29 = 268;
                }

                // wave_30
                wavex_30 += 3 * elapsedTime / 1000.0;
                wavey_301 -= 3 * elapsedTime / 1000.0;
                if (wavex_30 > 295 && wavey_301 < 457) {
                    wavex_30 = 290;
                    wavey_301 = 463;
                }

                // wave_31
                wavex_31 -= 4 * elapsedTime / 1000.0;
                wavey_311 -= 4 * elapsedTime / 1000.0;
                if (wavex_31 < 283 && wavey_311 < 471) {
                    wavex_31 = 290;
                    wavey_311 = 473;
                }

                // wave_32

                wavex_32 -= 5 * elapsedTime / 1000.0;
                if (wavex_32 < 395) {
                    wavex_32 = 400;
                }

                // wave_33
                wavex_33 += 3 * elapsedTime / 1000.0;
                wavey_331 -= 3 * elapsedTime / 1000.0;
                if (wavex_33 > 280 && wavey_331 < 485) {
                    wavex_33 = 273;
                    wavey_331 = 495;
                }

                // wave_34
                wavex_34 -= 3 * elapsedTime / 1000.0;
                wavey_341 -= 3 * elapsedTime / 1000.0;
                if (wavex_34 < 315 && wavey_341 < 507) {
                    wavex_34 = 325;
                    wavey_341 = 510;
                }

                // wave_35
                wavex_35 += 5 * elapsedTime / 1000.0;
                if (wavex_35 > 290) {
                    wavex_35 = 280;
                }

                // wave_36
                wavex_36 -= 3 * elapsedTime / 1000.0;
                wavey_361 -= 3 * elapsedTime / 1000.0;
                if (wavex_36 < 325 && wavey_361 < 515) {
                    wavex_36 = 330;
                    wavey_361 = 518;
                }

                // wave_37

                wavex_37 += 3 * elapsedTime / 1000.0;
                if (wavex_37 > 328) {
                    wavex_37 = 325;
                }

                // wave_38

                wavex_38 += 3 * elapsedTime / 1000.0;
                if (wavex_38 > 303) {
                    wavex_38 = 300;
                }

                // wave_39

                wavex_39 += 2 * elapsedTime / 1000.0;
                if (wavex_39 > 291) {
                    wavex_39 = 289;
                }

                // wave_40

                wavex_40 += 3 * elapsedTime / 1000.0;
                if (wavex_40 > 289) {
                    wavex_40 = 286;
                }

                // display

                repaint();
                Toolkit.getDefaultToolkit().sync();

            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gradientBG = new GradientPaint(202, 0, new Color(0xb2645a), 202, 300, new Color(0xc6524e));

            // for BG
            g2.setPaint(gradientBG);
            g2.fillRect(0, 0, 600, 600);

            // g2.drawImage(image, 0, 0, null);
            // SKY------------------------------------------------------
            // sky flare level 4
            g2.setColor(new Color(0xcd7360));
            fillMidpointCircle(g, 302, 295, 255, 3);
            // sky flare level 3
            g2.setColor(new Color(0xd8715d));
            fillMidpointCircle(g, 302, 302, 237, 3);
            // sky flare level 2
            g2.setColor(new Color(0xed7257));
            fillMidpointCircle(g, 302, 302, 210, 3);
            // sky flare level 1.5 (blend)
            g2.setColor(new Color(0xF48259));
            fillMidpointCircle(g, 302, 302, 150, 3);
            // sky flare level 1
            g2.setColor(new Color(0xff875c));
            fillMidpointCircle(g, 302, 302, 125, 3);

            // SUN------------------------------------------------------
            // sun core - fill
            g2.setColor(Color.WHITE);
            fillMidpointCircle(g, 302, (int) velocityY, 45, 3);
            // sun light
            g2.setColor(new Color(0xffe764));
            midpointCircle(g, 302, (int) velocityY, 48, 3);

            // CLOUD -------------------------------------------------------
            paintCloud(g2);
            paintSea(g2);
            paintWave(g2);

            g2.dispose();
            // end buffered
            g.drawImage(buffer, 0, 0, null);
        }

        protected void paintCloud(Graphics2D g2) {
            // Color for Cloud

            // EDIT START (OPTIMIZATION)
            // Java Built-in ไม่มี Gradient วงรีเลยใช้วงกลมแทนแล้วใช้รัศมีด้านที่ไหญ่กว่า
            RadialGradientPaint gradientRED = new RadialGradientPaint(311, 310, 390, new float[] { 0.0f, 1.0f },
                    new Color[] { new Color(0xff544b), new Color(0x5b4b53) });
            // EDIT END

            // CLOUD mid-------------------------------------------------------
            GradientPaint gradientOrange = new GradientPaint(311, 40, new Color(0xf66b5d), 311, 92,
                    new Color(0xfeb26a));
            // violet+++++++++++++++++++++++++++++++++++++++++++++++++++++
            // large cloud 1
            g2.setPaint(gradientOrange);
            // detail h orange
            fillMidpointEllipse(g2, 67 + (int) circleMove, 112, 5, 3, 3);
            fillMidpointEllipse(g2, 57 + (int) circleMove, 123, 25, 10, 3);
            fillMidpointEllipse(g2, 59 + (int) circleMove, 112, 12, 1, 1);
            fillMidpointEllipse(g2, 44 + (int) circleMove, 149, 50, 20, 1);

            fillMidpointEllipse(g2, 100 + (int) circleMove, 142, 9, 5, 6);

            g2.setPaint(gradientRED);

            fillMidpointEllipse(g2, 10 + (int) circleMove, 204, 100, 55, 3);
            plot(g2, 10, 204, 3);
            plot(g2, 60, 204, 3);
            plot(g2, 90, 204, 3);
            // detail h
            fillMidpointEllipse(g2, 50 + (int) circleMove, 170, 80, 20, 3);
            fillMidpointEllipse(g2, 100 + (int) circleMove, 145, 9, 5, 3);
            fillMidpointEllipse(g2, 100 + (int) circleMove, 150, 15, 5, 3);
            fillMidpointEllipse(g2, 70 + (int) circleMove, 150, 20, 10, 3);
            fillMidpointEllipse(g2, 20 + (int) circleMove, 142, 2, 1, 3);
            // detail v
            fillMidpointEllipse(g2, 50 + (int) circleMove, 154, 5, 10, 3);
            fillMidpointEllipse(g2, 10 + (int) circleMove, 154, 5, 10, 3);
            fillMidpointEllipse(g2, 15 + (int) circleMove, 152, 5, 10, 3);

            // large cloud 2
            fillMidpointEllipse(g2, 170 + (int) circleMove, 197, 110, 65, 3);
            g2.setPaint(gradientOrange);
            // detail h orange
            fillMidpointEllipse(g2, 259 + (int) circleMove, 72, 15, 7, 3);

            fillMidpointEllipse(g2, 316 + (int) circleMove, 135, 5, 3, 3);
            fillMidpointEllipse(g2, 314 + (int) circleMove, 140, 8, 2, 3);
            fillMidpointEllipse(g2, 297 + (int) circleMove, 76, 20, 8, 3);

            fillMidpointEllipse(g2, 256 + (int) circleMove, 129, 43, 18, 3);
            fillMidpointEllipse(g2, 296 + (int) circleMove, 111, 16, 12, 3);
            fillMidpointCircle(g2, 290 + (int) circleMove, 95, 18, 3);
            fillMidpointEllipse(g2, 317 + (int) circleMove, 122, 6, 3, 2);

            fillMidpointEllipse(g2, 281 + (int) circleMove, 150, 10, 7, 2);
            fillMidpointEllipse(g2, 281 + (int) circleMove, 158, 10, 9, 2);
            fillMidpointEllipse(g2, 274 + (int) circleMove, 172, 10, 7, 2);
            fillMidpointEllipse(g2, 285 + (int) circleMove, 165, 6, 1, 1);

            fillMidpointEllipse(g2, 210 + (int) circleMove, 100, 40, 30, 1);
            fillMidpointEllipse(g2, 170 + (int) circleMove, 124, 40, 35, 1);

            // detail v orange+++++++++++++++++++++++
            fillMidpointCircle(g2, 290 + (int) circleMove, 85, 1, 10);
            fillMidpointEllipse(g2, 291 + (int) circleMove, 88, 1, 4, 10);
            fillMidpointEllipse(g2, 272 + (int) circleMove, 136, 3, 6, 11);
            fillMidpointEllipse(g2, 219 + (int) circleMove, 73, 9, 18, 11);
            fillMidpointEllipse(g2, 193 + (int) circleMove, 80, 8, 10, 11);
            fillMidpointEllipse(g2, 165 + (int) circleMove, 90, 8, 10, 10);
            fillMidpointCircle(g2, 137 + (int) circleMove, 111, 8, 11);
            fillMidpointEllipse(g2, 127 + (int) circleMove, 131, 10, 20, 11);

            // detail h
            g2.setPaint(gradientRED);
            fillMidpointEllipse(g2, 245 + (int) circleMove, 124, 10, 6, 2);
            fillMidpointEllipse(g2, 266 + (int) circleMove, 122, 10, 3, 2);

            fillMidpointEllipse(g2, 285 + (int) circleMove, 150, 6, 3, 2);
            fillMidpointEllipse(g2, 290 + (int) circleMove, 95, 6, 2, 3);
            fillMidpointEllipse(g2, 242 + (int) circleMove, 62, 12, 7, 3);
            fillMidpointEllipse(g2, 172 + (int) circleMove, 137, 50, 25, 3);
            fillMidpointEllipse(g2, 175 + (int) circleMove, 125, 50, 25, 3);
            fillMidpointEllipse(g2, 199 + (int) circleMove, 110, 50, 25, 3);
            fillMidpointEllipse(g2, 230 + (int) circleMove, 100, 60, 25, 3);
            fillMidpointEllipse(g2, 244 + (int) circleMove, 84, 30, 19, 3);
            fillMidpointEllipse(g2, 240 + (int) circleMove, 170, 38, 10, 3);
            fillMidpointEllipse(g2, 237 + (int) circleMove, 160, 38, 17, 3);
            fillMidpointCircle(g2, 272 + (int) circleMove, 149, 9, 3);
            fillMidpointEllipse(g2, 275 + (int) circleMove, 140, 6, 3, 3);
            fillMidpointEllipse(g2, 53 + (int) circleMove, 122, 15, 8, 3);
            fillMidpointEllipse(g2, 36 + (int) circleMove, 129, 9, 3, 3);
            fillMidpointEllipse(g2, 34 + (int) circleMove, 133, 11, 2, 2);

            // small trim
            fillMidpointEllipse(g2, 119 + (int) circleMove, 151, 10, 4, 3);
            fillMidpointEllipse(g2, 111 + (int) circleMove, 140, 3, 2, 3);

            // detail v
            g2.setPaint(gradientRED);
            fillMidpointCircle(g2, 293 + (int) circleMove, 87, 1, 2);
            fillMidpointEllipse(g2, 295 + (int) circleMove, 90, 1, 4, 3);
            fillMidpointEllipse(g2, 275 + (int) circleMove, 140, 3, 6, 3);
            fillMidpointEllipse(g2, 221 + (int) circleMove, 75, 9, 18, 3);
            fillMidpointEllipse(g2, 196 + (int) circleMove, 82, 8, 10, 3);
            fillMidpointEllipse(g2, 168 + (int) circleMove, 94, 8, 10, 3);
            fillMidpointCircle(g2, 140 + (int) circleMove, 113, 8, 3);
            fillMidpointEllipse(g2, 130 + (int) circleMove, 135, 10, 20, 3);
            // large cloud 3
            g2.setPaint(gradientRED);
            fillMidpointEllipse(g2, 300 + (int) circleMove, 220, 50, 38, 3);
            // detail h
            fillMidpointEllipse(g2, 348 + (int) circleMove, 210, 60, 38, 3);
            fillMidpointEllipse(g2, 348 + (int) circleMove, 170, 25, 10, 3);
            fillMidpointEllipse(g2, 380 + (int) circleMove, 170, 25, 6, 3);

            // large cloud 4
            fillMidpointEllipse(g2, 400 + (int) circleMove, 218, 48, 35, 3);
            // large cloud 5
            fillMidpointEllipse(g2, 509 + (int) circleMove, 205, 75, 35, 3);
            g2.setPaint(gradientOrange);
            // detail h orange
            fillMidpointEllipse(g2, 480 + (int) circleMove, 170, 30, 20, 3);
            fillMidpointEllipse(g2, 440 + (int) circleMove, 181, 40, 4, 3);
            fillMidpointEllipse(g2, 448 + (int) circleMove, 162, 20, 4, 3);

            g2.setPaint(gradientRED);
            // detail h
            fillMidpointEllipse(g2, 540 + (int) circleMove, 144, 25, 5, 3);
            fillMidpointEllipse(g2, 484 + (int) circleMove, 162, 20, 7, 3);
            fillMidpointEllipse(g2, 470 + (int) circleMove, 167, 20, 4, 3);
            fillMidpointEllipse(g2, 560 + (int) circleMove, 180, 75, 35, 3);
            fillMidpointEllipse(g2, 435 + (int) circleMove, 220, 205, 35, 3);
            fillMidpointEllipse(g2, 560 + (int) circleMove, 214, 75, 35, 3);

            // CLOUD mid base
            g2.setPaint(gradientOrange);
            fillMidpointEllipse(g2, 320 + (int) circleMove, 258, 94, 3, 2);
            fillMidpointEllipse(g2, 367 + (int) circleMove, 261, 55, 3, 2);

            g2.setPaint(gradientRED);
            fillMidpointEllipse(g2, 0 + (int) circleMove, 258, 50, 1, 2);
            fillMidpointEllipse(g2, 100 + (int) circleMove, 265, 15, 1, 2);
            fillMidpointEllipse(g2, 103 + (int) circleMove, 245, 55, 20, 2);
            fillMidpointEllipse(g2, 330 + (int) circleMove, 258, 100, 1, 2);
            fillMidpointEllipse(g2, 202 + (int) circleMove, 265, 24, 1, 2);
            fillMidpointEllipse(g2, 545 + (int) circleMove, 250, 64, 1, 2);

            fillMidpointEllipse(g2, 253 + (int) circleMove, 250, 84, 10, 2);

            // // CLOUD lowest-------------------------------------------------------
            g2.setPaint(gradientOrange);
            // 1 large
            fillMidpointEllipse(g2, 35 + (int) circleMove, 290, 300, 15, 6);
            // 2 medium
            fillMidpointEllipse(g2, 270 + (int) circleMove, 296, 100, 7, 6);
            // 3 small
            fillMidpointEllipse(g2, 350 + (int) circleMove, 302, 40, 7, 6);
            // 5 large
            fillMidpointEllipse(g2, 450 + (int) circleMove, 296, 100, 7, 6);
            // 6 large
            fillMidpointEllipse(g2, 550 + (int) circleMove, 296, 100, 7, 6);
            // detail h
            fillMidpointEllipse(g2, 415 + (int) circleMove, 293, 30, 7, 7);
            fillMidpointEllipse(g2, 486 + (int) circleMove, 290, 10, 7, 7);
            fillMidpointEllipse(g2, 517 + (int) circleMove, 285, 30, 10, 7);
            fillMidpointEllipse(g2, 550 + (int) circleMove, 288, 10, 7, 7);

            fillMidpointEllipse(g2, 276 + (int) circleMove, 282, 15, 7, 3);

            g2.setPaint(gradientRED);

            fillMidpointEllipse(g2, 272 + (int) circleMove, 281, 8, 2, 3);
            // 1 large
            fillMidpointEllipse(g2, 35 + (int) circleMove, 292, 300, 15, 3);
            // 2 medium
            fillMidpointEllipse(g2, 270 + (int) circleMove, 300, 100, 7, 3);
            // 3 small
            fillMidpointEllipse(g2, 350 + (int) circleMove, 306, 40, 7, 3);
            // 5 large
            fillMidpointEllipse(g2, 450 + (int) circleMove, 300, 100, 7, 3);
            // 6 large
            fillMidpointEllipse(g2, 550 + (int) circleMove, 300, 100, 7, 3);
            // 7
            fillMidpointEllipse(g2, 417 + (int) circleMove, 294, 30, 7, 3);
            fillMidpointEllipse(g2, 490 + (int) circleMove, 290, 10, 7, 3);
            fillMidpointEllipse(g2, 517 + (int) circleMove, 287, 30, 7, 3);
            fillMidpointEllipse(g2, 550 + (int) circleMove, 290, 10, 7, 3);

            fillMidpointEllipse(g2, 567 + (int) circleMove, 270, 10, 2, 1);
            fillMidpointEllipse(g2, 577 + (int) circleMove, 260, 15, 2, 1);

            // connect
            fillMidpointEllipse(g2, 73 + (int) circleMove, 269, 20, 10, 1);
            fillMidpointEllipse(g2, 125 + (int) circleMove, 269, 15, 18, 1);

            // // CLOUD highest-------------------------------------------------------
            g2.setPaint(gradientOrange);
            fillMidpointEllipse(g2, 210 + (int) circleMove, 32, 76, 5, 3);
            // 3 cube
            fillMidpointEllipse(g2, 295 + (int) circleMove, 7, 15, 7, 3);
            fillMidpointCircle(g2, 311 + (int) circleMove, 8, 7, 3);
            fillMidpointEllipse(g2, 326 + (int) circleMove, 7, 11, 6, 3);
            //
            fillMidpointEllipse(g2, 340 + (int) circleMove, 28, 11, 6, 3);
            fillMidpointEllipse(g2, 360 + (int) circleMove, 28, 11, 6, 3);

            // below 3
            fillMidpointEllipse(g2, 347 + (int) circleMove, 35, 31, 6, 3);
            fillMidpointEllipse(g2, 338 + (int) circleMove, 42, 21, 6, 3);
            fillMidpointEllipse(g2, 347 + (int) circleMove, 48, 16, 6, 3);
            //
            fillMidpointEllipse(g2, 390 + (int) circleMove, 53, 26, 16, 3);
            fillMidpointEllipse(g2, 417 + (int) circleMove, 42, 16, 6, 3);
            fillMidpointEllipse(g2, 443 + (int) circleMove, 46, 22, 10, 3);
            fillMidpointEllipse(g2, 448 + (int) circleMove, 64, 38, 8, 3);
            //
            fillMidpointEllipse(g2, 429 + (int) circleMove, 23, 38, 8, 3);
            fillMidpointEllipse(g2, 423 + (int) circleMove, 16, 18, 8, 3);
            fillMidpointEllipse(g2, 465 + (int) circleMove, 15, 18, 3, 3);
            fillMidpointEllipse(g2, 474 + (int) circleMove, 25, 18, 8, 3);
            fillMidpointEllipse(g2, 504 + (int) circleMove, 36, 22, 8, 3);
            fillMidpointEllipse(g2, 505 + (int) circleMove, 43, 23, 2, 2);
            fillMidpointEllipse(g2, 526 + (int) circleMove, 18, 28, 15, 2);
            fillMidpointEllipse(g2, 570 + (int) circleMove, 26, 28, 15, 2);
            fillMidpointEllipse(g2, 546 + (int) circleMove, 38, 18, 7, 2);
            fillMidpointEllipse(g2, 568 + (int) circleMove, 14, 18, 5, 2);
            //
            fillMidpointEllipse(g2, 545 + (int) circleMove, 70, 38, 9, 2);
            fillMidpointEllipse(g2, 555 + (int) circleMove, 90, 38, 9, 2);
            fillMidpointEllipse(g2, 531 + (int) circleMove, 80, 20, 5, 2);

            // first
            fillMidpointEllipse(g2, 120 + (int) circleMove, 30, 31, 6, 3);
            fillMidpointEllipse(g2, 82 + (int) circleMove, 55, 31, 6, 3);

            g2.setPaint(gradientRED);
            // 1 medium
            fillMidpointEllipse(g2, 0 + (int) circleMove, 10, 100, 18, 3);

            // 2 medium aka below 1
            fillMidpointEllipse(g2, 0 + (int) circleMove, 35, 65, 10, 3);

            // 3 small
            fillMidpointEllipse(g2, 90 + (int) circleMove, 20, 30, 9, 3);

            // 4 large
            fillMidpointEllipse(g2, 170 + (int) circleMove, 25, 96, 10, 3);

            // 5 small
            fillMidpointEllipse(g2, 255 + (int) circleMove, 25, 25, 7, 3);

            // 6 medium
            fillMidpointEllipse(g2, 75 + (int) circleMove, 40, 20, 7, 3);
            // 6.5
            fillMidpointEllipse(g2, 75 + (int) circleMove, 45, 50, 5, 3);
            fillMidpointEllipse(g2, 95 + (int) circleMove, 55, 40, 3, 3);
            // detail violet
            // 7
            fillMidpointEllipse(g2, 374 + (int) circleMove, 40, 30, 10, 3);
            // 8
            fillMidpointEllipse(g2, 400 + (int) circleMove, 55, 28, 8, 3);
            // 9
            fillMidpointEllipse(g2, 470 + (int) circleMove, 65, 20, 6, 3);
            // 10 small
            fillMidpointEllipse(g2, 498 + (int) circleMove, 35, 10, 3, 3);
            // 11 small
            fillMidpointEllipse(g2, 520 + (int) circleMove, 20, 10, 3, 3);
            // 12 small
            fillMidpointEllipse(g2, 570 + (int) circleMove, 20, 30, 8, 3);
            // 13 small
            fillMidpointEllipse(g2, 574 + (int) circleMove, 40, 30, 5, 3);
            // 14 small
            fillMidpointEllipse(g2, 574 + (int) circleMove, 70, 30, 5, 3);
            // 15 small
            fillMidpointEllipse(g2, 572 + (int) circleMove, 80, 40, 5, 3);
            // tiny
            fillMidpointEllipse(g2, 555 + (int) circleMove, 37, 10, 1, 1);

            fillMidpointEllipse(g2, 550 + (int) circleMove, 92, 10, 1, 1);
            fillMidpointEllipse(g2, 536 + (int) circleMove, 82, 10, 1, 1);

            // SMALL PART
            g2.setPaint(gradientOrange);
            fillMidpointEllipse(g2, 44 + (int) circleMove, 88, 10, 2, 3);
            g2.setPaint(gradientRED);
            fillMidpointEllipse(g2, 15 + (int) circleMove, 62, 10, 2, 3);
            fillMidpointEllipse(g2, 33 + (int) circleMove, 91, 10, 2, 3);

            fillMidpointEllipse(g2, 538 + (int) circleMove, 20, 10, 2, 3);
        }

        protected void paintSea(Graphics2D g2) {
            GradientPaint gradientSea = new GradientPaint(301, 400, new Color(0xea8568), 301, 460, new Color(0x935147));
            GradientPaint gradientShadow = new GradientPaint(301, 400, new Color(0xa18f89), 301, 460,
                    new Color(0x4f4953));
            // background sea

            g2.setPaint(gradientSea);

            midpointEllipse(g2, 280, 320, 290, 10, 30);
            midpointEllipse(g2, 280, 350, 290, 10, 30);

            midpointEllipse(g2, 280, 380, 290, 10, 30);
            midpointEllipse(g2, 280, 410, 290, 10, 30);
            midpointEllipse(g2, 280, 440, 290, 10, 30);
            midpointEllipse(g2, 280, 470, 290, 10, 30);
            midpointEllipse(g2, 280, 500, 290, 10, 30);
            midpointEllipse(g2, 280, 530, 290, 10, 30);
            midpointEllipse(g2, 280, 560, 290, 10, 30);

            midpointEllipse(g2, 10, 320, 500, 10, 30);
            midpointEllipse(g2, 10, 560, 500, 10, 30);
            midpointEllipse(g2, 10, 560, 500, 10, 30);
            midpointEllipse(g2, 420, 580, 80, 10, 10);
            midpointEllipse(g2, 450, 580, 80, 10, 10);
            midpointEllipse(g2, 480, 580, 80, 10, 10);
            midpointEllipse(g2, 588, 585, 2, 2, 10);
            midpointEllipse(g2, 585, 585, 5, 5, 10);
            midpointEllipse(g2, 575, 585, 5, 5, 10);
            midpointEllipse(g2, 565, 585, 5, 5, 10);
            midpointEllipse(g2, 545, 585, 45, 5, 10);
            midpointEllipse(g2, 535, 585, 53, 5, 10);
            midpointEllipse(g2, 597, 597, 2, 2, 2);
            midpointEllipse(g2, 588, 315, 2, 2, 10);
            midpointEllipse(g2, 585, 315, 5, 5, 10);
            midpointEllipse(g2, 575, 315, 5, 5, 10);
            midpointEllipse(g2, 565, 315, 5, 5, 10);
            midpointEllipse(g2, 545, 315, 45, 5, 10);
            midpointEllipse(g2, 535, 315, 53, 5, 10);
            midpointEllipse(g2, 596, 313, 2, 2, 2);
            midpointEllipse(g2, 590, 313, 2, 2, 2);

            midpointEllipse(g2, 440, 311, 198, 1, 1);
            midpointEllipse(g2, 440, 312, 198, 1, 1);

            // wave left

            // --------------------------------------------------------------------------------

            g2.setPaint(gradientShadow);
            midpointEllipse(g2, -180, 317, 300, 2, 2);
            midpointEllipse(g2, -110, 322, 300, 1, 1);
            midpointEllipse(g2, -60, 330, 300, 1, 1);
            midpointEllipse(g2, -70, 327, 300, 1, 1);
            midpointEllipse(g2, -120, 328, 300, 4, 4);
            midpointEllipse(g2, -125, 340, 300, 4, 4);
            midpointEllipse(g2, -98, 345, 300, 4, 4);
            midpointEllipse(g2, -40, 340, 300, 1, 1);
            midpointEllipse(g2, -60, 370, 300, 10, 3);
            midpointEllipse(g2, -80, 375, 300, 10, 8);
            midpointEllipse(g2, 100, 435, 125, 5, 5);
            midpointEllipse(g2, 100, 445, 140, 5, 5);
            midpointEllipse(g2, 105, 445, 149, 5, 5);
            midpointEllipse(g2, 500, 410, 100, 11, 10);
            midpointEllipse(g2, 515, 358, 100, 1, 1);
            midpointEllipse(g2, -10, 475, 280, 30, 17);
            midpointEllipse(g2, 10, 490, 280, 20, 17);
            midpointEllipse(g2, 30, 490, 280, 20, 5);
            midpointEllipse(g2, 10, 500, 280, 30, 16);
            midpointEllipse(g2, 30, 520, 280, 30, 10);

            midpointEllipse(g2, 10, 533, 280, 30, 13);
            midpointEllipse(g2, 10, 533, 280, 30, 13);
            midpointEllipse(g2, -10, 550, 280, 30, 13);
            midpointEllipse(g2, -15, 560, 280, 30, 7);
            midpointEllipse(g2, -15, 560, 280, 30, 7);
            midpointEllipse(g2, -15, 570, 280, 10, 7);
            midpointEllipse(g2, -6, 573, 280, 10, 3);
            midpointEllipse(g2, -22, 586, 280, 15, 10);
            midpointEllipse(g2, 510, 530, 200, 8, 10);
            midpointEllipse(g2, 500, 542, 200, 8, 10);
            midpointEllipse(g2, 495, 555, 200, 8, 17);
            midpointEllipse(g2, 500, 380, 150, 5, 20);
            midpointEllipse(g2, 480, 400, 150, 5, 10);

            g2.setColor(new Color(0x6F757B));
            midpointEllipse(g2, 503, 545, 200, 8, 5);
            midpointEllipse(g2, 510, 550, 200, 8, 8);
            midpointEllipse(g2, 105, 454, 140, 5, 3);

            midpointEllipse(g2, 200, 517, 100, 5, 5);
            midpointEllipse(g2, 250, 526, 100, 3, 5);
            midpointEllipse(g2, 170, 528, 100, 5, 5);

            g2.setPaint(gradientShadow);
            g2.setColor(new Color(0x9A9DA0));
            midpointEllipse(g2, 105, 450, 140, 5, 4);

            g2.setColor(Color.DARK_GRAY); // เฉพาะจุด
            g2.setColor(new Color(0x6F757B));
            midpointEllipse(g2, -80, 375, 300, 10, 3);
            midpointEllipse(g2, 45, 483, 60, 7, 15);

            g2.setColor(Color.DARK_GRAY); // เฉพาะจุด
            g2.setColor(new Color(0x8F9194));
            midpointEllipse(g2, -60, 363, 300, 10, 5);
            midpointEllipse(g2, 404, 460, 100, 12, 10);
            midpointEllipse(g2, 390, 460, 150, 1, 1);
            midpointEllipse(g2, 418, 463, 150, 1, 2);
            midpointEllipse(g2, 510, 438, 70, 8, 20);
            midpointEllipse(g2, 130, 420, 150, 5, 10);

            g2.setPaint(gradientShadow);

            midpointEllipse(g2, -50, 360, 300, 10, 4);
            midpointEllipse(g2, 200, 400, 150, 5, 10);

            midpointEllipse(g2, 5, 348, 300, 1, 2);
            midpointEllipse(g2, -10, 350, 300, 1, 2);
            midpointEllipse(g2, -50, 343, 300, 1, 1);
            midpointEllipse(g2, -90, 360, 300, 1, 1);
            midpointEllipse(g2, -110, 360, 300, 1, 2);
            midpointEllipse(g2, -100, 363, 300, 1, 2);
            midpointEllipse(g2, 300, 410, 100, 1, 2);
            midpointEllipse(g2, 0, 416, 105, 1, 2);
            midpointEllipse(g2, 0, 430, 220, 1, 2);
            midpointEllipse(g2, 0, 428, 240, 1, 1);
            midpointEllipse(g2, 90, 432, 100, 1, 2);
            midpointEllipse(g2, 0, 435, 200, 1, 2);
            midpointEllipse(g2, 0, 437, 30, 1, 1);

            midpointEllipse(g2, -90, 555, 300, 1, 2);
            midpointEllipse(g2, -90, 555, 300, 3, 3);
            midpointEllipse(g2, -100, 570, 300, 3, 3);
            midpointEllipse(g2, -50, 570, 300, 1, 1);

            g2.setColor(Color.BLACK);// เฉพาะจุด
            g2.setColor(new Color(0x5F6266));

            midpointEllipse(g2, 183, 380, 50, 1, 1);
            midpointEllipse(g2, 190, 391, 100, 1, 1);
            midpointEllipse(g2, 120, 396, 100, 1, 1);
            midpointEllipse(g2, 100, 400, 100, 1, 2);
            midpointEllipse(g2, 150, 407, 50, 1, 1);
            midpointEllipse(g2, 177, 403, 50, 1, 2);
            midpointEllipse(g2, 195, 401, 50, 1, 1);
            midpointEllipse(g2, 190, 403, 50, 1, 1);
            midpointEllipse(g2, 67, 408, 50, 1, 2);
            midpointEllipse(g2, 90, 413, 50, 1, 1);
            midpointEllipse(g2, 250, 417, 100, 1, 1);
            midpointEllipse(g2, 300, 422, 100, 1, 1);
            midpointEllipse(g2, 340, 415, 100, 1, 1);
            midpointEllipse(g2, 340, 395, 110, 1, 1);
            midpointEllipse(g2, 420, 398, 110, 1, 1);
            midpointEllipse(g2, 400, 400, 110, 1, 2);
            midpointEllipse(g2, 440, 400, 110, 1, 1);
            midpointEllipse(g2, 500, 405, 100, 1, 2);
            midpointEllipse(g2, 415, 409, 190, 1, 1);

            g2.setColor(new Color(0x9A9DA0));
            // วงรี
            midpointEllipse(g2, 500, 365, 150, 5, 15);
            midpointEllipse(g2, 480, 365, 150, 5, 8);

            midpointEllipse(g2, 296, 403, 300, 20, 5);
            midpointEllipse(g2, 396, 415, 200, 15, 3);
            midpointEllipse(g2, 296, 410, 200, 15, 3);

            midpointEllipse(g2, 480, 475, 150, 10, 10);
            midpointEllipse(g2, 470, 485, 150, 10, 10);
            midpointEllipse(g2, 485, 500, 150, 8, 5);
            midpointEllipse(g2, 485, 580, 200, 10, 15);
            //

            // --------------------------------------------------------------------------------

            g2.setPaint(gradientShadow);
            midpointEllipse(g2, 475, 580, 200, 10, 6);
            midpointEllipse(g2, 482, 555, 200, 10, 8);
            midpointEllipse(g2, 470, 507, 150, 8, 5);
            midpointEllipse(g2, 470, 465, 150, 10, 5);
            midpointEllipse(g2, 499, 515, 150, 2, 8);
            midpointEllipse(g2, 490, 520, 150, 2, 8);

            midpointEllipse(g2, -120, 315, 300, 1, 1);
            midpointEllipse(g2, -135, 325, 300, 2, 2);
            midpointEllipse(g2, -100, 333, 300, 3, 3);
            midpointEllipse(g2, -50, 343, 300, 1, 1);
            midpointEllipse(g2, -80, 345, 300, 1, 1);
            midpointEllipse(g2, -100, 350, 300, 2, 2);
            midpointEllipse(g2, -20, 355, 300, 1, 2);
            midpointEllipse(g2, -130, 363, 300, 1, 2);
            midpointEllipse(g2, 0, 420, 105, 1, 1);
            midpointEllipse(g2, 0, 442, 20, 1, 2);
            midpointEllipse(g2, 0, 442, 50, 1, 1);
            midpointEllipse(g2, 40, 438, 35, 1, 2);
            midpointEllipse(g2, 70, 438, 30, 1, 1);
            midpointEllipse(g2, 0, 450, 100, 1, 2);
            midpointEllipse(g2, 10, 453, 100, 1, 2);
            midpointEllipse(g2, 100, 456, 30, 1, 2);
            midpointEllipse(g2, 200, 450, 50, 1, 2);
            midpointEllipse(g2, 110, 445, 149, 1, 2);
            midpointEllipse(g2, 100, 460, 100, 1, 2);
            midpointEllipse(g2, 80, 464, 150, 1, 1);
            midpointEllipse(g2, 0, 470, 80, 1, 2);
            midpointEllipse(g2, 80, 468, 70, 1, 2);
            midpointEllipse(g2, 105, 473, 190, 1, 1);
            midpointEllipse(g2, 99, 476, 40, 1, 1);
            midpointEllipse(g2, 80, 480, 60, 1, 2);
            midpointEllipse(g2, 60, 483, 60, 1, 1);
            midpointEllipse(g2, 240, 492, 150, 1, 2);
            midpointEllipse(g2, 200, 496, 150, 1, 1);
            midpointEllipse(g2, 180, 500, 150, 1, 1);
            midpointEllipse(g2, 0, 505, 150, 1, 1);
            midpointEllipse(g2, 50, 507, 50, 1, 1);
            midpointEllipse(g2, 75, 510, 50, 1, 1);
            midpointEllipse(g2, 0, 522, 100, 1, 1);
            midpointEllipse(g2, 90, 525, 70, 1, 1);
            midpointEllipse(g2, 0, 525, 35, 1, 2);
            midpointEllipse(g2, 0, 527, 160, 1, 2);
            midpointEllipse(g2, 110, 520, 160, 1, 2);
            midpointEllipse(g2, 150, 517, 100, 1, 2);
            midpointEllipse(g2, 177, 557, 100, 6, 5);
            midpointEllipse(g2, 65, 555, 200, 20, 5);
            midpointEllipse(g2, 180, 585, 80, 2, 4);
            midpointEllipse(g2, 0, 585, 80, 1, 1);
            midpointEllipse(g2, -180, 590, 300, 2, 2);
            midpointEllipse(g2, -80, 567, 300, 3, 2);

            // วงรี

            g2.setPaint(gradientShadow);

            midpointEllipse(g2, 296, 400, 300, 20, 3);
            midpointEllipse(g2, 100, 405, 300, 20, 3);

            // --------------------------------------------------------------------------------

            g2.setColor(new Color(0x5F6266));

            midpointEllipse(g2, 50, 330, 20, 1, 1);
            midpointEllipse(g2, 100, 343, 10, 1, 2);
            midpointEllipse(g2, 70, 355, 50, 1, 1);
            midpointEllipse(g2, 168, 363, 55, 1, 1);
            midpointEllipse(g2, 0, 370, 55, 1, 1);
            midpointEllipse(g2, 150, 438, 50, 1, 2);
            midpointEllipse(g2, 170, 438, 50, 1, 1);
            midpointEllipse(g2, 130, 442, 50, 1, 1);
            midpointEllipse(g2, 100, 443, 50, 1, 1);
            midpointEllipse(g2, 140, 450, 45, 1, 2);
            midpointEllipse(g2, 225, 445, 30, 1, 1);
            midpointEllipse(g2, 0, 460, 20, 1, 1);
            midpointEllipse(g2, 180, 468, 40, 1, 2);
            midpointEllipse(g2, 155, 477, 28, 1, 2);
            midpointEllipse(g2, 230, 465, 28, 1, 1);
            midpointEllipse(g2, 250, 463, 28, 1, 1);
            midpointEllipse(g2, 210, 475, 40, 1, 2);
            midpointEllipse(g2, 180, 475, 40, 1, 1);
            midpointEllipse(g2, 30, 476, 45, 1, 2);
            midpointEllipse(g2, 0, 487, 30, 1, 1);
            midpointEllipse(g2, 50, 486, 14, 1, 2);
            midpointEllipse(g2, 200, 485, 100, 1, 2);
            midpointEllipse(g2, 250, 480, 200, 1, 1);
            midpointEllipse(g2, 60, 490, 60, 1, 1);
            midpointEllipse(g2, 100, 513, 40, 1, 2);
            midpointEllipse(g2, 40, 515, 35, 1, 2);
            midpointEllipse(g2, 140, 511, 50, 1, 1);
            midpointEllipse(g2, 150, 514, 50, 1, 1);
            midpointEllipse(g2, 0, 517, 20, 1, 2);
            midpointEllipse(g2, 30, 518, 40, 1, 1);
            midpointEllipse(g2, 110, 522, 35, 1, 2);
            midpointEllipse(g2, 250, 510, 20, 1, 2);
            midpointEllipse(g2, 230, 506, 20, 1, 2);
            midpointEllipse(g2, 220, 509, 20, 1, 1);
            midpointEllipse(g2, 270, 508, 20, 1, 1);
            midpointEllipse(g2, 200, 527, 20, 1, 1);
            midpointEllipse(g2, 250, 540, 40, 3, 2);
            midpointEllipse(g2, 190, 538, 40, 1, 1);
            midpointEllipse(g2, 280, 538, 40, 1, 2);
            midpointEllipse(g2, 90, 545, 50, 1, 2);
            midpointEllipse(g2, 50, 543, 50, 1, 1);
            midpointEllipse(g2, 120, 548, 50, 1, 1);
            midpointEllipse(g2, 90, 552, 20, 1, 1);
            midpointEllipse(g2, 80, 554, 15, 1, 1);
            midpointEllipse(g2, 50, 558, 40, 2, 2);
            midpointEllipse(g2, 20, 555, 20, 1, 1);
            midpointEllipse(g2, 150, 558, 40, 1, 2);
            midpointEllipse(g2, 137, 562, 40, 2, 1);
            midpointEllipse(g2, 210, 555, 60, 1, 1);
            midpointEllipse(g2, -80, 500, 300, 2, 2);

            g2.setPaint(gradientShadow);
            g2.setColor(new Color(0x9A9DA0));
            midpointEllipse(g2, -80, 577, 300, 3, 2);
            midpointEllipse(g2, 200, 571, 80, 1, 1);

            g2.setColor(new Color(0x5F6266));
            midpointEllipse(g2, 200, 577, 50, 1, 2);

            // ------------------------------------------------------------------------------
            // wave right
            g2.setPaint(gradientShadow);

            midpointEllipse(g2, 510, 319, 105, 1, 2);
            midpointEllipse(g2, 500, 325, 115, 1, 2);
            midpointEllipse(g2, 500, 325, 115, 1, 2);
            midpointEllipse(g2, 385, 325, 15, 1, 2);
            midpointEllipse(g2, 392, 329, 10, 1, 2);
            midpointEllipse(g2, 277, 370, 20, 1, 2);
            midpointEllipse(g2, 268, 372, 20, 1, 2);

            midpointEllipse(g2, 268, 364, 20, 1, 2);
            midpointEllipse(g2, 355, 364, 50, 1, 2);
            midpointEllipse(g2, 343, 367, 45, 1, 2);

            midpointEllipse(g2, 480, 333, 110, 5, 10);
            midpointEllipse(g2, 455, 333, 110, 1, 1);
            midpointEllipse(g2, 458, 336, 110, 1, 2);
            midpointEllipse(g2, 450, 339, 110, 1, 1);

            midpointEllipse(g2, 403, 341, 50, 1, 2);
            midpointEllipse(g2, 580, 415, 20, 1, 2);
            midpointEllipse(g2, 583, 396, 20, 1, 2);
            midpointEllipse(g2, 570, 397, 50, 3, 2);

            midpointEllipse(g2, 460, 393, 100, 1, 1);

            midpointEllipse(g2, 0, 392, 100, 1, 1);
            midpointEllipse(g2, 0, 395, 40, 3, 2);
            midpointEllipse(g2, 0, 398, 70, 1, 1);
            midpointEllipse(g2, 0, 405, 100, 1, 1);
            midpointEllipse(g2, 0, 408, 40, 3, 2);
            midpointEllipse(g2, 0, 411, 70, 1, 1);
            midpointEllipse(g2, 460, 424, 100, 3, 2);

            midpointEllipse(g2, 440, 444, 160, 10, 6);
            midpointEllipse(g2, 245, 435, 20, 1, 2);
            midpointEllipse(g2, 248, 438, 40, 1, 1);
            midpointEllipse(g2, 250, 440, 20, 1, 1);
            midpointEllipse(g2, 500, 435, 100, 10, 10);
            midpointEllipse(g2, 350, 470, 70, 2, 1);
            midpointEllipse(g2, 370, 473, 70, 2, 2);
            midpointEllipse(g2, 430, 462, 190, 1, 1);
            midpointEllipse(g2, 330, 455, 50, 1, 1);
            midpointEllipse(g2, 250, 452, 20, 1, 1);

            midpointEllipse(g2, 290, 503, 30, 1, 1);
            midpointEllipse(g2, 100, 490, 100, 1, 1);
            midpointEllipse(g2, 150, 510, 120, 1, 1);
            midpointEllipse(g2, 120, 547, 80, 2, 1);
            midpointEllipse(g2, 150, 550, 80, 2, 1);
            midpointEllipse(g2, 300, 532, 50, 2, 1);
            midpointEllipse(g2, 330, 500, 10, 1, 1);
            midpointEllipse(g2, 336, 503, 10, 1, 1);
            midpointEllipse(g2, 460, 525, 150, 5, 3);
            midpointEllipse(g2, 420, 517, 100, 1, 1);
            midpointEllipse(g2, 580, 570, 60, 1, 1);
            midpointEllipse(g2, 560, 550, 60, 1, 1);
            midpointEllipse(g2, 580, 553, 60, 1, 1);
            midpointEllipse(g2, 580, 555, 60, 3, 1);
            midpointEllipse(g2, 430, 552, 60, 3, 1);

            midpointEllipse(g2, 340, 552, 100, 1, 1);
            midpointEllipse(g2, 365, 595, 100, 3, 1);
            midpointEllipse(g2, 365, 591, 100, 3, 1);

            midpointEllipse(g2, 358, 585, 100, 1, 1);
            midpointEllipse(g2, 361, 582, 100, 1, 1);
            midpointEllipse(g2, 200, 585, 100, 1, 1);
            midpointEllipse(g2, 380, 493, 100, 2, 1);
            midpointEllipse(g2, 515, 358, 100, 1, 1);

            g2.setColor(new Color(0x6F757B));

            midpointEllipse(g2, 540, 317, 70, 1, 1);
            midpointEllipse(g2, 500, 350, 85, 1, 2);
            midpointEllipse(g2, 500, 350, 109, 3, 2);
            midpointEllipse(g2, 390, 346, 109, 1, 1);
            midpointEllipse(g2, 390, 346, 109, 1, 1);
            midpointEllipse(g2, 525, 346, 30, 1, 1);
            midpointEllipse(g2, 560, 340, 50, 1, 1);
            midpointEllipse(g2, 530, 355, 109, 3, 2);
            midpointEllipse(g2, 525, 355, 90, 1, 2);
            midpointEllipse(g2, 525, 362, 87, 1, 1);
            midpointEllipse(g2, 430, 355, 87, 4, 4);
            midpointEllipse(g2, 430, 355, 87, 4, 4);
            midpointEllipse(g2, 300, 355, 87, 1, 1);
            midpointEllipse(g2, 285, 359, 30, 1, 1);
            midpointEllipse(g2, 490, 370, 110, 3, 3);
            midpointEllipse(g2, 460, 369, 40, 1, 2);
            midpointEllipse(g2, 560, 372, 40, 1, 2);
            midpointEllipse(g2, 580, 421, 50, 1, 1);
            midpointEllipse(g2, 580, 418, 30, 1, 2);
            midpointEllipse(g2, 580, 390, 50, 1, 1);
            midpointEllipse(g2, 580, 393, 20, 1, 2);
            midpointEllipse(g2, 450, 379, 100, 1, 1);
            midpointEllipse(g2, 520, 438, 100, 2, 3);
            midpointEllipse(g2, 437, 450, 40, 2, 2);
            midpointEllipse(g2, 440, 445, 100, 2, 2);
            midpointEllipse(g2, 440, 448, 150, 1, 2);
            midpointEllipse(g2, 490, 470, 70, 2, 2);
            midpointEllipse(g2, 430, 465, 200, 1, 1);
            midpointEllipse(g2, 570, 485, 80, 1, 1);
            midpointEllipse(g2, 560, 489, 120, 1, 2);
            midpointEllipse(g2, 450, 492, 30, 1, 2);
            midpointEllipse(g2, 428, 490, 30, 1, 1);
            midpointEllipse(g2, 418, 495, 50, 1, 1);
            midpointEllipse(g2, 422, 498, 50, 1, 2);
            midpointEllipse(g2, 490, 501, 100, 1, 2);
            midpointEllipse(g2, 590, 498, 40, 1, 2);
            midpointEllipse(g2, 530, 505, 100, 3, 2);
            midpointEllipse(g2, 420, 330, 100, 2, 1);
            midpointEllipse(g2, 560, 330, 40, 2, 2);

            g2.setPaint(gradientShadow);

            midpointEllipse(g2, 550, 380, 80, 3, 2);
            midpointEllipse(g2, 510, 382, 30, 1, 2);
            midpointEllipse(g2, 570, 379, 30, 1, 1);
            midpointEllipse(g2, 570, 385, 50, 1, 1);
            midpointEllipse(g2, 570, 430, 50, 1, 1);
            midpointEllipse(g2, 580, 427, 30, 1, 2);
            midpointEllipse(g2, 500, 432, 80, 2, 2);
            midpointEllipse(g2, 420, 436, 30, 2, 2);
            midpointEllipse(g2, 420, 436, 60, 1, 1);
            midpointEllipse(g2, 580, 424, 65, 1, 1);
            midpointEllipse(g2, 355, 375, 20, 1, 2);
            midpointEllipse(g2, 357, 378, 40, 1, 1);
            midpointEllipse(g2, 345, 432, 20, 1, 1);
            midpointEllipse(g2, 350, 434, 10, 1, 2);
            midpointEllipse(g2, 343, 437, 10, 1, 1);
            midpointEllipse(g2, 330, 439, 17, 1, 1);
            midpointEllipse(g2, 295, 438, 13, 1, 2);
            midpointEllipse(g2, 305, 444, 8, 1, 1);
            midpointEllipse(g2, 264, 444, 11, 1, 1);
            midpointEllipse(g2, 360, 444, 18, 1, 1);
            midpointEllipse(g2, 500, 448, 25, 1, 2);
            midpointEllipse(g2, 510, 446, 40, 1, 1);
            midpointEllipse(g2, 470, 450, 40, 1, 1);
            midpointEllipse(g2, 430, 483, 80, 1, 2);
            midpointEllipse(g2, 420, 482, 80, 1, 1);
            midpointEllipse(g2, 490, 478, 50, 1, 1);
            midpointEllipse(g2, 520, 476, 50, 2, 2);
            midpointEllipse(g2, 510, 474, 80, 1, 1);
            midpointEllipse(g2, 582, 471, 20, 1, 2);
            midpointEllipse(g2, 510, 498, 100, 1, 1);
            midpointEllipse(g2, 490, 504, 10, 1, 2);
            midpointEllipse(g2, 512, 494, 50, 1, 1);
            midpointEllipse(g2, 532, 508, 50, 1, 1);
            midpointEllipse(g2, 565, 505, 30, 1, 1);
            midpointEllipse(g2, 430, 508, 40, 1, 2);
            midpointEllipse(g2, 397, 512, 50, 1, 1);
            midpointEllipse(g2, 410, 506, 50, 1, 1);
            midpointEllipse(g2, 400, 520, 20, 1, 2);
            midpointEllipse(g2, 450, 524, 70, 1, 1);
            midpointEllipse(g2, 413, 540, 100, 3, 4);
            midpointEllipse(g2, 485, 535, 100, 1, 2);
            midpointEllipse(g2, 510, 540, 30, 1, 1);
            midpointEllipse(g2, 530, 538, 30, 1, 1);
            midpointEllipse(g2, 350, 558, 15, 1, 2);
            midpointEllipse(g2, 355, 562, 50, 1, 1);
            midpointEllipse(g2, 370, 560, 50, 1, 1);
            midpointEllipse(g2, 385, 565, 100, 1, 2);
            midpointEllipse(g2, 370, 568, 100, 1, 1);
            midpointEllipse(g2, 385, 565, 100, 1, 2);
            midpointEllipse(g2, 470, 560, 20, 1, 2);
            midpointEllipse(g2, 483, 564, 20, 1, 1);
            midpointEllipse(g2, 490, 562, 20, 1, 2);
            midpointEllipse(g2, 490, 562, 60, 1, 1);
            midpointEllipse(g2, 395, 580, 60, 1, 2);
            midpointEllipse(g2, 420, 333, 20, 1, 1);
            midpointEllipse(g2, 460, 340, 10, 1, 2);
            midpointEllipse(g2, 510, 353, 40, 2, 1);
            midpointEllipse(g2, 520, 365, 100, 3, 2);
            midpointEllipse(g2, 530, 335, 20, 1, 2);

            g2.setColor(new Color(0x9A9DA0));
            midpointEllipse(g2, 395, 446, 150, 1, 1);
            midpointEllipse(g2, 515, 356, 100, 1, 1);
            midpointEllipse(g2, 520, 359, 100, 1, 1);

        }

        protected void paintWave(Graphics2D g2) {

            g2.setColor(new Color(0xf9e2cd));
            // wave_0
            midpointEllipse(g2, (int) wavex_01, (int) wavey_0, 75, 1, 2);

            // wave_1
            midpointEllipse(g2, (int) wavex_1, (int) wavey_11, 70, 1, 2);

            // wave_2
            midpointEllipse(g2, (int) wavex_2, (int) wavey_21, 40, 1, 2);

            // wave_3
            midpointEllipse(g2, (int) wavex_3, (int) wavey_31, 40, 1, 2);

            // wave_4
            midpointEllipse(g2, (int) wavex_4, (int) wavey_41, 30, 1, 2);

            // wave_5
            midpointEllipse(g2, (int) wavex_5, (int) wavey_51, 35, 1, 2);

            // wave_6
            midpointEllipse(g2, (int) wavex_6, (int) wavey_61, 45, 1, 2);

            // wave_7
            midpointEllipse(g2, (int) wavex_7, (int) wavey_71, 35, 1, 2);

            // wave_8
            midpointEllipse(g2, (int) wavex_8, (int) wavey_81, 25, 1, 2);

            // wave_9
            midpointEllipse(g2, (int) wavex_9, (int) wavey_91, 25, 1, 2);

            // wave_10
            midpointEllipse(g2, (int) wavex_10, (int) wavey_101, 35, 1, 2);

            // wave_11
            midpointEllipse(g2, (int) wavex_11, (int) wavey_111, 23, 1, 2);

            // wave_12
            midpointEllipse(g2, (int) wavex_12, (int) wavey_121, 22, 1, 2);

            // wave_13
            midpointEllipse(g2, (int) wavex_13, (int) wavey_131, 30, 1, 2);

            // wave_14
            midpointEllipse(g2, (int) wavex_14, (int) wavey_141, 15, 1, 2);

            // wave_15
            midpointEllipse(g2, (int) wavex_15, (int) wavey_151, 10, 1, 2);

            // wave_16
            midpointEllipse(g2, (int) wavex_16, (int) wavey_161, 10, 1, 2);

            // wave_17
            midpointEllipse(g2, (int) wavex_17, (int) wavey_171, 10, 1, 2);

            // wave_18
            midpointEllipse(g2, (int) wavex_18, (int) wavey_181, 30, 1, 2);

            // wave_19
            midpointEllipse(g2, (int) wavex_19, (int) wavey_191, 18, 1, 2);

            // wave_20
            midpointEllipse(g2, (int) wavex_20, (int) wavey_201, 30, 1, 2);

            // wave_21
            midpointEllipse(g2, (int) wavex_21, (int) wavey_211, 25, 1, 2);

            // wave_22
            midpointEllipse(g2, (int) wavex_22, (int) wavey_221, 25, 1, 2);

            // wave_23
            midpointEllipse(g2, (int) wavex_23, (int) wavey_231, 10, 1, 2);

            // wave_24
            midpointEllipse(g2, (int) wavex_24, (int) wavey_241, 20, 1, 2);

            // wave_25
            midpointEllipse(g2, (int) wavex_25, (int) wavey_251, 15, 1, 2);

            // wave_26
            midpointEllipse(g2, (int) wavex_26, (int) wavey_261, 30, 1, 2);

            // wave_27
            midpointEllipse(g2, (int) wavex_27, (int) wavey_271, 10, 1, 2);
            // wave_28
            midpointEllipse(g2, (int) wavex_28, (int) wavey_281, 10, 1, 2);

            // wave_29
            midpointEllipse(g2, (int) wavex_29, (int) wavey_291, 10, 1, 2);

            // wave_30
            midpointEllipse(g2, (int) wavex_30, (int) wavey_301, 7, 1, 2);

            // wave_31
            midpointEllipse(g2, (int) wavex_31, (int) wavey_311, 12, 1, 2);

            // wave_32
            midpointEllipse(g2, (int) wavex_32, (int) wavey_321, 10, 1, 2);

            // wave_33
            midpointEllipse(g2, (int) wavex_33, (int) wavey_331, 7, 1, 2);

            // wave_34
            midpointEllipse(g2, (int) wavex_34, (int) wavey_341, 10, 1, 2);

            // wave_35
            midpointEllipse(g2, (int) wavex_35, (int) wavey_351, 7, 1, 2);

            // wave_36
            midpointEllipse(g2, (int) wavex_36, (int) wavey_361, 7, 1, 2);

            // wave_37
            midpointEllipse(g2, (int) wavex_37, (int) wavey_371, 5, 1, 2);

            // wave_38
            midpointEllipse(g2, (int) wavex_38, (int) wavey_381, 5, 1, 2);

            // wave_39
            midpointEllipse(g2, (int) wavex_39, (int) wavey_391, 2, 1, 2);

            // wave_40
            midpointEllipse(g2, (int) wavex_40, (int) wavey_401, 4, 1, 2);

        }

        private void plot(Graphics g, int x, int y, int size) {
            g.fillRect(x, y, size, size);
        }

        public void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
            int aa = a * a, bb = b * b;
            int x, y, d;
            // region 1
            x = 0;
            y = b;
            d = Math.round(bb - aa * b + aa / 4f);

            while (bb * x <= aa * y) {

                int x1 = x + xc, x2 = -x + xc, y1 = y + yc, y2 = -y + yc;

                plot(g, x1, y1, size);
                plot(g, x2, y1, size);
                plot(g, x1, y2, size);
                plot(g, x2, y2, size);

                x++;
                d = d + 2 * bb * x + bb;

                if (d >= 0) {
                    y--;
                    d = d - 2 * aa * y;
                }

            }

            // region 2
            x = a;
            y = 0;
            d = Math.round(aa - bb * a + bb / 4f);

            while (bb * x >= aa * y) {
                int x1 = x + xc, x2 = -x + xc, y1 = y + yc, y2 = -y + yc;

                plot(g, x1, y1, size);
                plot(g, x2, y1, size);
                plot(g, x1, y2, size);
                plot(g, x2, y2, size);

                y++;
                d = d + 2 * aa * y + aa;

                if (d >= 0) {
                    x--;
                    d = d - 2 * bb * x;
                }

            }

        }

        public void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
            int x = 0;
            int y = r;
            int d = 1 - r;
            int dx = 2 * x;
            int dy = 2 * y;

            while (x <= y) {
                plot(g, x + xc, y + yc, size);
                plot(g, -x + xc, y + yc, size);
                plot(g, x + xc, -y + yc, size);
                plot(g, -x + xc, -y + yc, size);
                plot(g, y + xc, x + yc, size);
                plot(g, -y + xc, x + yc, size);
                plot(g, y + xc, -x + yc, size);
                plot(g, -y + xc, -x + yc, size);
                x++;

                dx += 2;

                d = d + dx + 1;

                if (d >= 0) {
                    y--;
                    dy -= 2;
                    d = d - dy;

                }
            }
        }

        public void fillMidpointCircle(Graphics g, int xc, int yc, int r, int size) {
            int sizeOffset = size / 2;
            midpointFillCircle(g, xc + sizeOffset, yc + sizeOffset, r + size);
        }

        public void fillMidpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
            int sizeOffset = size / 2;
            midpointFillEllipse(g, xc + sizeOffset, yc + sizeOffset, a + sizeOffset, b + sizeOffset);
        }

        private void midpointFillCircle(Graphics g, int midX, int midY, int radius) {
            int x = 0;
            int y = radius;
            int dx = 0; // dx = 2 * x;
            int dy = 2 * y;
            int d = 1 - radius;

            while (x <= y) {

                int x2 = x + x, y2 = y + y;

                if (x != y) {
                    g.fillRect(midX - y, midY + x, y2, 1); // [midY - y -> midY + y] [midX + x]
                    if (x != 0)
                        g.fillRect(midX - y, midY - x, y2, 1); // [midY - y -> midY + y] [midX - x]
                }

                x++;
                dx += 2;
                d += dx + 1;

                if (d >= 0) {
                    // only draw strips when y value is changed to prevent overlaps (single y
                    // multiple x)
                    g.fillRect(midX - x + 1, midY + y, x2, 1); // [midX - x -> midX + x] [midY + y]
                    g.fillRect(midX - x + 1, midY - y, x2, 1); // [midX - x -> midX + x] [midY - y]
                    y--;
                    dy -= 2;
                    d -= dy;
                }
            }
        }

        private void midpointFillEllipse(Graphics g, int midX, int midY, int radiusX, int radiusY) {
            final int RRX = radiusX * radiusX;
            final int RRY = radiusY * radiusY;

            // Ellipse Region 1
            int x = 0;
            int y = radiusY;
            int dx = 0;
            int dy = 2 * RRX * y;
            int d = Math.round(RRY - RRX * radiusY + RRX * 0.25f);

            while (dx <= dy) {
                int x2 = x + x;

                x++;
                dx += 2 * RRY;
                d += dx + RRY;

                if (d >= 0) {

                    // only draw strips when y value is changed to prevent overlaps (single y
                    // multiple x)
                    g.fillRect(midX - x + 1, midY + y, x2, 1); // [midX - x -> midX + x] [midY + y]
                    g.fillRect(midX - x + 1, midY - y, x2, 1); // [midX - x -> midX + x] [midY - y]

                    y--;
                    dy -= 2 * RRX;
                    d -= dy;

                }
            }

            // Ellipse Region 2
            x = radiusX;
            y = 0;
            dx = 2 * RRY * x;
            dy = 0;
            d = Math.round(RRX - RRY * radiusX + RRY * 0.25f);

            while (dx >= dy) {
                int x2 = x + x;

                g.fillRect(midX - x, midY + y, x2, 1); // [midX - x -> midX + x] [midY + y]
                if (y != 0)
                    g.fillRect(midX - x, midY - y, x2, 1); // [midX - x -> midX + x] [midY - y]

                y++;
                dy += 2 * RRX;
                d += dy + RRX;

                if (d >= 0) {
                    x--;
                    dx -= 2 * RRY;
                    d -= dx;
                }
            }
        }

    }

}
