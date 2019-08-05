package tech.kaushik.sourabh.com.customeloader.MergedLoaders;


import android.content.Context;

import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.ClassicSpinner;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.FlashSpinner;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.LineSpinner;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.PhoneWave;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.ProgressDots;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.Pulse;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.Radar;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.Sharingan;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.TwinFishesSpinner;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.Whirlpool;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.type.Worm;
import tech.kaushik.sourabh.com.customeloader.ProgressDotsView.AVLoadingIndicatorView;

/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class LoaderGenerator {

    public static LoaderView generateLoaderView(int type) {

        switch (type) {
            case 0:
                return new ClassicSpinner();
            case 1:
                return new FlashSpinner();
            case 2:
                return new LineSpinner();
            case 3:
                try {
                    return new Pulse(3);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case 4:
                try {
                    return new Pulse(4);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case 5:
                try {
                    return new Pulse(5);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case 6:
                return new Radar();
            case 7:
                return new TwinFishesSpinner();
            case 8:
                return new Worm();
            case 9:
                return new Whirlpool();
            case 10:
                return new PhoneWave();
            case 11:
                return new Sharingan();
            case 12:
                return  new ProgressDots();
            default:
                return new ClassicSpinner();
        }
    }

    public static LoaderView generateLoaderView(String type) {
        switch (type) {
            case "ClassicSpinner":
                return new ClassicSpinner();
            case "FishSpinner":
                return new FlashSpinner();
            case "LineSpinner":
                return new LineSpinner();
            case "ThreePulse":
                try {
                    return new Pulse(3);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case "FourPulse":
                try {
                    return new Pulse(4);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case "FivePulse":
                try {
                    return new Pulse(5);
                } catch (InvalidNumberOfPulseException e) {
                    e.printStackTrace();
                }
            case "Radar":
                return new Radar();
            case "TwinFishesSpinner":
                return new TwinFishesSpinner();
            case "Worm":
                return new Worm();
            case "Whirlpool":
                return new Whirlpool();
            case "PhoneWave":
                return new PhoneWave();
            case "Sharingan":
                return new Sharingan();
            case "ProgressDots":
                return  new ProgressDots();
            default:
                return new ClassicSpinner();
        }
    }
}

