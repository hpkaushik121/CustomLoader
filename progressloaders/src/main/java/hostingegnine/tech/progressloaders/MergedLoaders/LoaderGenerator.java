package hostingegnine.tech.progressloaders.MergedLoaders;


import android.content.Context;

import hostingegnine.tech.progressloaders.MergedLoaders.type.FlashSpinner;
import hostingegnine.tech.progressloaders.MergedLoaders.type.GearDuo;
import hostingegnine.tech.progressloaders.MergedLoaders.type.LineSpinner;
import hostingegnine.tech.progressloaders.MergedLoaders.type.PhoneWave;
import hostingegnine.tech.progressloaders.MergedLoaders.type.ProgressDots;
import hostingegnine.tech.progressloaders.MergedLoaders.type.Pulse;
import hostingegnine.tech.progressloaders.MergedLoaders.type.Radar;
import hostingegnine.tech.progressloaders.MergedLoaders.type.Sharingan;
import hostingegnine.tech.progressloaders.MergedLoaders.type.TwinFishesSpinner;
import hostingegnine.tech.progressloaders.MergedLoaders.type.Whirlpool;
import hostingegnine.tech.progressloaders.MergedLoaders.type.Worm;
import hostingegnine.tech.progressloaders.MergedLoaders.type.ClassicSpinner;
import hostingegnine.tech.progressloaders.R;

/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class LoaderGenerator {

    public static LoaderView generateLoaderView(int type, Context context,int resourceId) {

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
            case 13:
                return  new GearDuo(context,resourceId);
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

