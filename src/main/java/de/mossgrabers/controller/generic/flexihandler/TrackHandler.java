// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2020
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.controller.generic.flexihandler;

import de.mossgrabers.controller.generic.GenericFlexiConfiguration;
import de.mossgrabers.controller.generic.controller.FlexiCommand;
import de.mossgrabers.controller.generic.controller.GenericFlexiControlSurface;
import de.mossgrabers.framework.command.core.TriggerCommand;
import de.mossgrabers.framework.command.trigger.track.ToggleTrackBanksCommand;
import de.mossgrabers.framework.controller.valuechanger.IValueChanger;
import de.mossgrabers.framework.daw.IModel;
import de.mossgrabers.framework.daw.data.ISend;
import de.mossgrabers.framework.daw.data.ITrack;
import de.mossgrabers.framework.daw.data.bank.ISendBank;
import de.mossgrabers.framework.daw.data.bank.ITrackBank;
import de.mossgrabers.framework.daw.data.empty.EmptyTrack;
import de.mossgrabers.framework.utils.ButtonEvent;


/**
 * The handler for track commands.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class TrackHandler extends AbstractHandler
{
    private final TriggerCommand toggleTrackBankCommand;


    /**
     * Constructor.
     *
     * @param model The model
     * @param surface The surface
     * @param configuration The configuration
     * @param relative2ValueChanger The relative value changer variant 2
     * @param relative3ValueChanger The relative value changer variant 3
     */
    public TrackHandler (final IModel model, final GenericFlexiControlSurface surface, final GenericFlexiConfiguration configuration, final IValueChanger relative2ValueChanger, final IValueChanger relative3ValueChanger)
    {
        super (model, surface, configuration, relative2ValueChanger, relative3ValueChanger);

        this.toggleTrackBankCommand = new ToggleTrackBanksCommand<> (model, surface);
    }


    /** {@inheritDoc} */
    @Override
    public FlexiCommand [] getSupportedCommands ()
    {
        return new FlexiCommand []
        {
            FlexiCommand.TRACK_TOGGLE_TRACK_BANK,
            FlexiCommand.TRACK_ADD_AUDIO_TRACK,
            FlexiCommand.TRACK_ADD_EFFECT_TRACK,
            FlexiCommand.TRACK_ADD_INSTRUMENT_TRACK,
            FlexiCommand.TRACK_SELECT_PREVIOUS_BANK_PAGE,
            FlexiCommand.TRACK_SELECT_NEXT_BANK_PAGE,
            FlexiCommand.TRACK_SELECT_PREVIOUS_TRACK,
            FlexiCommand.TRACK_SELECT_NEXT_TRACK,
            FlexiCommand.TRACK_SCROLL_TRACKS,
            FlexiCommand.TRACK_1_SELECT,
            FlexiCommand.TRACK_2_SELECT,
            FlexiCommand.TRACK_3_SELECT,
            FlexiCommand.TRACK_4_SELECT,
            FlexiCommand.TRACK_5_SELECT,
            FlexiCommand.TRACK_6_SELECT,
            FlexiCommand.TRACK_7_SELECT,
            FlexiCommand.TRACK_8_SELECT,
            FlexiCommand.TRACK_1_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_2_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_3_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_4_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_5_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_6_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_7_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_8_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_1_SET_ACTIVE,
            FlexiCommand.TRACK_2_SET_ACTIVE,
            FlexiCommand.TRACK_3_SET_ACTIVE,
            FlexiCommand.TRACK_4_SET_ACTIVE,
            FlexiCommand.TRACK_5_SET_ACTIVE,
            FlexiCommand.TRACK_6_SET_ACTIVE,
            FlexiCommand.TRACK_7_SET_ACTIVE,
            FlexiCommand.TRACK_8_SET_ACTIVE,
            FlexiCommand.TRACK_SELECTED_TOGGLE_ACTIVE,
            FlexiCommand.TRACK_SELECTED_SET_ACTIVE,
            FlexiCommand.TRACK_1_SET_VOLUME,
            FlexiCommand.TRACK_2_SET_VOLUME,
            FlexiCommand.TRACK_3_SET_VOLUME,
            FlexiCommand.TRACK_4_SET_VOLUME,
            FlexiCommand.TRACK_5_SET_VOLUME,
            FlexiCommand.TRACK_6_SET_VOLUME,
            FlexiCommand.TRACK_7_SET_VOLUME,
            FlexiCommand.TRACK_8_SET_VOLUME,
            FlexiCommand.TRACK_SELECTED_SET_VOLUME_TRACK,
            FlexiCommand.TRACK_1_SET_PANORAMA,
            FlexiCommand.TRACK_2_SET_PANORAMA,
            FlexiCommand.TRACK_3_SET_PANORAMA,
            FlexiCommand.TRACK_4_SET_PANORAMA,
            FlexiCommand.TRACK_5_SET_PANORAMA,
            FlexiCommand.TRACK_6_SET_PANORAMA,
            FlexiCommand.TRACK_7_SET_PANORAMA,
            FlexiCommand.TRACK_8_SET_PANORAMA,
            FlexiCommand.TRACK_SELECTED_SET_PANORAMA,
            FlexiCommand.TRACK_1_TOGGLE_MUTE,
            FlexiCommand.TRACK_2_TOGGLE_MUTE,
            FlexiCommand.TRACK_3_TOGGLE_MUTE,
            FlexiCommand.TRACK_4_TOGGLE_MUTE,
            FlexiCommand.TRACK_5_TOGGLE_MUTE,
            FlexiCommand.TRACK_6_TOGGLE_MUTE,
            FlexiCommand.TRACK_7_TOGGLE_MUTE,
            FlexiCommand.TRACK_8_TOGGLE_MUTE,
            FlexiCommand.TRACK_1_SET_MUTE,
            FlexiCommand.TRACK_2_SET_MUTE,
            FlexiCommand.TRACK_3_SET_MUTE,
            FlexiCommand.TRACK_4_SET_MUTE,
            FlexiCommand.TRACK_5_SET_MUTE,
            FlexiCommand.TRACK_6_SET_MUTE,
            FlexiCommand.TRACK_7_SET_MUTE,
            FlexiCommand.TRACK_8_SET_MUTE,
            FlexiCommand.TRACK_SELECTED_TOGGLE_MUTE,
            FlexiCommand.TRACK_SELECTED_SET_MUTE,
            FlexiCommand.TRACK_1_TOGGLE_SOLO,
            FlexiCommand.TRACK_2_TOGGLE_SOLO,
            FlexiCommand.TRACK_3_TOGGLE_SOLO,
            FlexiCommand.TRACK_4_TOGGLE_SOLO,
            FlexiCommand.TRACK_5_TOGGLE_SOLO,
            FlexiCommand.TRACK_6_TOGGLE_SOLO,
            FlexiCommand.TRACK_7_TOGGLE_SOLO,
            FlexiCommand.TRACK_8_TOGGLE_SOLO,
            FlexiCommand.TRACK_1_SET_SOLO,
            FlexiCommand.TRACK_2_SET_SOLO,
            FlexiCommand.TRACK_3_SET_SOLO,
            FlexiCommand.TRACK_4_SET_SOLO,
            FlexiCommand.TRACK_5_SET_SOLO,
            FlexiCommand.TRACK_6_SET_SOLO,
            FlexiCommand.TRACK_7_SET_SOLO,
            FlexiCommand.TRACK_8_SET_SOLO,
            FlexiCommand.TRACK_SELECTED_TOGGLE_SOLO,
            FlexiCommand.TRACK_SELECTED_SET_SOLO,
            FlexiCommand.TRACK_1_TOGGLE_ARM,
            FlexiCommand.TRACK_2_TOGGLE_ARM,
            FlexiCommand.TRACK_3_TOGGLE_ARM,
            FlexiCommand.TRACK_4_TOGGLE_ARM,
            FlexiCommand.TRACK_5_TOGGLE_ARM,
            FlexiCommand.TRACK_6_TOGGLE_ARM,
            FlexiCommand.TRACK_7_TOGGLE_ARM,
            FlexiCommand.TRACK_8_TOGGLE_ARM,
            FlexiCommand.TRACK_1_SET_ARM,
            FlexiCommand.TRACK_2_SET_ARM,
            FlexiCommand.TRACK_3_SET_ARM,
            FlexiCommand.TRACK_4_SET_ARM,
            FlexiCommand.TRACK_5_SET_ARM,
            FlexiCommand.TRACK_6_SET_ARM,
            FlexiCommand.TRACK_7_SET_ARM,
            FlexiCommand.TRACK_8_SET_ARM,
            FlexiCommand.TRACK_SELECTED_TOGGLE_ARM,
            FlexiCommand.TRACK_SELECTED_SET_ARM,
            FlexiCommand.TRACK_1_TOGGLE_MONITOR,
            FlexiCommand.TRACK_2_TOGGLE_MONITOR,
            FlexiCommand.TRACK_3_TOGGLE_MONITOR,
            FlexiCommand.TRACK_4_TOGGLE_MONITOR,
            FlexiCommand.TRACK_5_TOGGLE_MONITOR,
            FlexiCommand.TRACK_6_TOGGLE_MONITOR,
            FlexiCommand.TRACK_7_TOGGLE_MONITOR,
            FlexiCommand.TRACK_8_TOGGLE_MONITOR,
            FlexiCommand.TRACK_1_SET_MONITOR,
            FlexiCommand.TRACK_2_SET_MONITOR,
            FlexiCommand.TRACK_3_SET_MONITOR,
            FlexiCommand.TRACK_4_SET_MONITOR,
            FlexiCommand.TRACK_5_SET_MONITOR,
            FlexiCommand.TRACK_6_SET_MONITOR,
            FlexiCommand.TRACK_7_SET_MONITOR,
            FlexiCommand.TRACK_8_SET_MONITOR,
            FlexiCommand.TRACK_SELECTED_TOGGLE_MONITOR,
            FlexiCommand.TRACK_SELECTED_SET_MONITOR,
            FlexiCommand.TRACK_1_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_2_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_3_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_4_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_5_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_6_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_7_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_8_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_1_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_2_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_3_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_4_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_5_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_6_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_7_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_8_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_SELECTED_TOGGLE_AUTO_MONITOR,
            FlexiCommand.TRACK_SELECTED_SET_AUTO_MONITOR,
            FlexiCommand.TRACK_1_SET_SEND_1,
            FlexiCommand.TRACK_2_SET_SEND_1,
            FlexiCommand.TRACK_3_SET_SEND_1,
            FlexiCommand.TRACK_4_SET_SEND_1,
            FlexiCommand.TRACK_5_SET_SEND_1,
            FlexiCommand.TRACK_6_SET_SEND_1,
            FlexiCommand.TRACK_7_SET_SEND_1,
            FlexiCommand.TRACK_8_SET_SEND_1,
            FlexiCommand.TRACK_1_SET_SEND_2,
            FlexiCommand.TRACK_2_SET_SEND_2,
            FlexiCommand.TRACK_3_SET_SEND_2,
            FlexiCommand.TRACK_4_SET_SEND_2,
            FlexiCommand.TRACK_5_SET_SEND_2,
            FlexiCommand.TRACK_6_SET_SEND_2,
            FlexiCommand.TRACK_7_SET_SEND_2,
            FlexiCommand.TRACK_8_SET_SEND_2,
            FlexiCommand.TRACK_1_SET_SEND_3,
            FlexiCommand.TRACK_2_SET_SEND_3,
            FlexiCommand.TRACK_3_SET_SEND_3,
            FlexiCommand.TRACK_4_SET_SEND_3,
            FlexiCommand.TRACK_5_SET_SEND_3,
            FlexiCommand.TRACK_6_SET_SEND_3,
            FlexiCommand.TRACK_7_SET_SEND_3,
            FlexiCommand.TRACK_8_SET_SEND_3,
            FlexiCommand.TRACK_1_SET_SEND_4,
            FlexiCommand.TRACK_2_SET_SEND_4,
            FlexiCommand.TRACK_3_SET_SEND_4,
            FlexiCommand.TRACK_4_SET_SEND_4,
            FlexiCommand.TRACK_5_SET_SEND_4,
            FlexiCommand.TRACK_6_SET_SEND_4,
            FlexiCommand.TRACK_7_SET_SEND_4,
            FlexiCommand.TRACK_8_SET_SEND_4,
            FlexiCommand.TRACK_1_SET_SEND_5,
            FlexiCommand.TRACK_2_SET_SEND_5,
            FlexiCommand.TRACK_3_SET_SEND_5,
            FlexiCommand.TRACK_4_SET_SEND_5,
            FlexiCommand.TRACK_5_SET_SEND_5,
            FlexiCommand.TRACK_6_SET_SEND_5,
            FlexiCommand.TRACK_7_SET_SEND_5,
            FlexiCommand.TRACK_8_SET_SEND_5,
            FlexiCommand.TRACK_1_SET_SEND_6,
            FlexiCommand.TRACK_2_SET_SEND_6,
            FlexiCommand.TRACK_3_SET_SEND_6,
            FlexiCommand.TRACK_4_SET_SEND_6,
            FlexiCommand.TRACK_5_SET_SEND_6,
            FlexiCommand.TRACK_6_SET_SEND_6,
            FlexiCommand.TRACK_7_SET_SEND_6,
            FlexiCommand.TRACK_8_SET_SEND_6,
            FlexiCommand.TRACK_1_SET_SEND_7,
            FlexiCommand.TRACK_2_SET_SEND_7,
            FlexiCommand.TRACK_3_SET_SEND_7,
            FlexiCommand.TRACK_4_SET_SEND_7,
            FlexiCommand.TRACK_5_SET_SEND_7,
            FlexiCommand.TRACK_6_SET_SEND_7,
            FlexiCommand.TRACK_7_SET_SEND_7,
            FlexiCommand.TRACK_8_SET_SEND_7,
            FlexiCommand.TRACK_1_SET_SEND_8,
            FlexiCommand.TRACK_2_SET_SEND_8,
            FlexiCommand.TRACK_3_SET_SEND_8,
            FlexiCommand.TRACK_4_SET_SEND_8,
            FlexiCommand.TRACK_5_SET_SEND_8,
            FlexiCommand.TRACK_6_SET_SEND_8,
            FlexiCommand.TRACK_7_SET_SEND_8,
            FlexiCommand.TRACK_8_SET_SEND_8,
            FlexiCommand.TRACK_SELECTED_SET_SEND_1,
            FlexiCommand.TRACK_SELECTED_SET_SEND_2,
            FlexiCommand.TRACK_SELECTED_SET_SEND_3,
            FlexiCommand.TRACK_SELECTED_SET_SEND_4,
            FlexiCommand.TRACK_SELECTED_SET_SEND_5,
            FlexiCommand.TRACK_SELECTED_SET_SEND_6,
            FlexiCommand.TRACK_SELECTED_SET_SEND_7,
            FlexiCommand.TRACK_SELECTED_SET_SEND_8
        };
    }


    /** {@inheritDoc} */
    @Override
    public int getCommandValue (final FlexiCommand command)
    {
        final ITrackBank trackBank = this.model.getCurrentTrackBank ();
        if (trackBank == null)
            return -1;

        switch (command)
        {
            case TRACK_1_SELECT:
            case TRACK_2_SELECT:
            case TRACK_3_SELECT:
            case TRACK_4_SELECT:
            case TRACK_5_SELECT:
            case TRACK_6_SELECT:
            case TRACK_7_SELECT:
            case TRACK_8_SELECT:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SELECT.ordinal ()).isSelected () ? 127 : 0;

            case TRACK_1_TOGGLE_ACTIVE:
            case TRACK_2_TOGGLE_ACTIVE:
            case TRACK_3_TOGGLE_ACTIVE:
            case TRACK_4_TOGGLE_ACTIVE:
            case TRACK_5_TOGGLE_ACTIVE:
            case TRACK_6_TOGGLE_ACTIVE:
            case TRACK_7_TOGGLE_ACTIVE:
            case TRACK_8_TOGGLE_ACTIVE:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_ACTIVE.ordinal ()).isActivated () ? 127 : 0;
            case TRACK_1_SET_ACTIVE:
            case TRACK_2_SET_ACTIVE:
            case TRACK_3_SET_ACTIVE:
            case TRACK_4_SET_ACTIVE:
            case TRACK_5_SET_ACTIVE:
            case TRACK_6_SET_ACTIVE:
            case TRACK_7_SET_ACTIVE:
            case TRACK_8_SET_ACTIVE:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_ACTIVE.ordinal ()).isActivated () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_ACTIVE:
            case TRACK_SELECTED_SET_ACTIVE:
                final ITrack selectedTrack = this.model.getSelectedTrack ();
                return selectedTrack != null && selectedTrack.isActivated () ? 127 : 0;

            case TRACK_1_SET_VOLUME:
            case TRACK_2_SET_VOLUME:
            case TRACK_3_SET_VOLUME:
            case TRACK_4_SET_VOLUME:
            case TRACK_5_SET_VOLUME:
            case TRACK_6_SET_VOLUME:
            case TRACK_7_SET_VOLUME:
            case TRACK_8_SET_VOLUME:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_VOLUME.ordinal ()).getVolume ();

            case TRACK_SELECTED_SET_VOLUME_TRACK:
                final ITrack sel = this.model.getSelectedTrack ();
                return sel == null ? 0 : sel.getVolume ();

            case TRACK_1_SET_PANORAMA:
            case TRACK_2_SET_PANORAMA:
            case TRACK_3_SET_PANORAMA:
            case TRACK_4_SET_PANORAMA:
            case TRACK_5_SET_PANORAMA:
            case TRACK_6_SET_PANORAMA:
            case TRACK_7_SET_PANORAMA:
            case TRACK_8_SET_PANORAMA:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_PANORAMA.ordinal ()).getPan ();

            case TRACK_SELECTED_SET_PANORAMA:
                final ITrack selTrack = this.model.getSelectedTrack ();
                return selTrack == null ? 0 : selTrack.getPan ();

            case TRACK_1_TOGGLE_MUTE:
            case TRACK_2_TOGGLE_MUTE:
            case TRACK_3_TOGGLE_MUTE:
            case TRACK_4_TOGGLE_MUTE:
            case TRACK_5_TOGGLE_MUTE:
            case TRACK_6_TOGGLE_MUTE:
            case TRACK_7_TOGGLE_MUTE:
            case TRACK_8_TOGGLE_MUTE:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_MUTE.ordinal ()).isMute () ? 127 : 0;
            case TRACK_1_SET_MUTE:
            case TRACK_2_SET_MUTE:
            case TRACK_3_SET_MUTE:
            case TRACK_4_SET_MUTE:
            case TRACK_5_SET_MUTE:
            case TRACK_6_SET_MUTE:
            case TRACK_7_SET_MUTE:
            case TRACK_8_SET_MUTE:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_MUTE.ordinal ()).isMute () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_MUTE:
            case TRACK_SELECTED_SET_MUTE:
                final ITrack track = this.model.getSelectedTrack ();
                return track != null && track.isMute () ? 127 : 0;

            case TRACK_1_TOGGLE_SOLO:
            case TRACK_2_TOGGLE_SOLO:
            case TRACK_3_TOGGLE_SOLO:
            case TRACK_4_TOGGLE_SOLO:
            case TRACK_5_TOGGLE_SOLO:
            case TRACK_6_TOGGLE_SOLO:
            case TRACK_7_TOGGLE_SOLO:
            case TRACK_8_TOGGLE_SOLO:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_SOLO.ordinal ()).isSolo () ? 127 : 0;
            case TRACK_1_SET_SOLO:
            case TRACK_2_SET_SOLO:
            case TRACK_3_SET_SOLO:
            case TRACK_4_SET_SOLO:
            case TRACK_5_SET_SOLO:
            case TRACK_6_SET_SOLO:
            case TRACK_7_SET_SOLO:
            case TRACK_8_SET_SOLO:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_SOLO.ordinal ()).isSolo () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_SOLO:
            case TRACK_SELECTED_SET_SOLO:
                final ITrack track2 = this.model.getSelectedTrack ();
                return track2 != null && track2.isSolo () ? 127 : 0;

            case TRACK_1_TOGGLE_ARM:
            case TRACK_2_TOGGLE_ARM:
            case TRACK_3_TOGGLE_ARM:
            case TRACK_4_TOGGLE_ARM:
            case TRACK_5_TOGGLE_ARM:
            case TRACK_6_TOGGLE_ARM:
            case TRACK_7_TOGGLE_ARM:
            case TRACK_8_TOGGLE_ARM:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_ARM.ordinal ()).isRecArm () ? 127 : 0;
            case TRACK_1_SET_ARM:
            case TRACK_2_SET_ARM:
            case TRACK_3_SET_ARM:
            case TRACK_4_SET_ARM:
            case TRACK_5_SET_ARM:
            case TRACK_6_SET_ARM:
            case TRACK_7_SET_ARM:
            case TRACK_8_SET_ARM:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_ARM.ordinal ()).isRecArm () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_ARM:
            case TRACK_SELECTED_SET_ARM:
                final ITrack track3 = this.model.getSelectedTrack ();
                return track3 != null && track3.isRecArm () ? 127 : 0;

            case TRACK_1_TOGGLE_MONITOR:
            case TRACK_2_TOGGLE_MONITOR:
            case TRACK_3_TOGGLE_MONITOR:
            case TRACK_4_TOGGLE_MONITOR:
            case TRACK_5_TOGGLE_MONITOR:
            case TRACK_6_TOGGLE_MONITOR:
            case TRACK_7_TOGGLE_MONITOR:
            case TRACK_8_TOGGLE_MONITOR:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_MONITOR.ordinal ()).isMonitor () ? 127 : 0;
            case TRACK_1_SET_MONITOR:
            case TRACK_2_SET_MONITOR:
            case TRACK_3_SET_MONITOR:
            case TRACK_4_SET_MONITOR:
            case TRACK_5_SET_MONITOR:
            case TRACK_6_SET_MONITOR:
            case TRACK_7_SET_MONITOR:
            case TRACK_8_SET_MONITOR:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_MONITOR.ordinal ()).isMonitor () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_MONITOR:
            case TRACK_SELECTED_SET_MONITOR:
                final ITrack track4 = this.model.getSelectedTrack ();
                return track4 != null && track4.isMonitor () ? 127 : 0;

            case TRACK_1_TOGGLE_AUTO_MONITOR:
            case TRACK_2_TOGGLE_AUTO_MONITOR:
            case TRACK_3_TOGGLE_AUTO_MONITOR:
            case TRACK_4_TOGGLE_AUTO_MONITOR:
            case TRACK_5_TOGGLE_AUTO_MONITOR:
            case TRACK_6_TOGGLE_AUTO_MONITOR:
            case TRACK_7_TOGGLE_AUTO_MONITOR:
            case TRACK_8_TOGGLE_AUTO_MONITOR:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_AUTO_MONITOR.ordinal ()).isAutoMonitor () ? 127 : 0;
            case TRACK_1_SET_AUTO_MONITOR:
            case TRACK_2_SET_AUTO_MONITOR:
            case TRACK_3_SET_AUTO_MONITOR:
            case TRACK_4_SET_AUTO_MONITOR:
            case TRACK_5_SET_AUTO_MONITOR:
            case TRACK_6_SET_AUTO_MONITOR:
            case TRACK_7_SET_AUTO_MONITOR:
            case TRACK_8_SET_AUTO_MONITOR:
                return trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_AUTO_MONITOR.ordinal ()).isAutoMonitor () ? 127 : 0;

            case TRACK_SELECTED_TOGGLE_AUTO_MONITOR:
            case TRACK_SELECTED_SET_AUTO_MONITOR:
                final ITrack track5 = this.model.getSelectedTrack ();
                return track5 != null && track5.isAutoMonitor () ? 127 : 0;

            case TRACK_1_SET_SEND_1:
            case TRACK_2_SET_SEND_1:
            case TRACK_3_SET_SEND_1:
            case TRACK_4_SET_SEND_1:
            case TRACK_5_SET_SEND_1:
            case TRACK_6_SET_SEND_1:
            case TRACK_7_SET_SEND_1:
            case TRACK_8_SET_SEND_1:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_1.ordinal (), 0);

            case TRACK_1_SET_SEND_2:
            case TRACK_2_SET_SEND_2:
            case TRACK_3_SET_SEND_2:
            case TRACK_4_SET_SEND_2:
            case TRACK_5_SET_SEND_2:
            case TRACK_6_SET_SEND_2:
            case TRACK_7_SET_SEND_2:
            case TRACK_8_SET_SEND_2:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_2.ordinal (), 1);

            case TRACK_1_SET_SEND_3:
            case TRACK_2_SET_SEND_3:
            case TRACK_3_SET_SEND_3:
            case TRACK_4_SET_SEND_3:
            case TRACK_5_SET_SEND_3:
            case TRACK_6_SET_SEND_3:
            case TRACK_7_SET_SEND_3:
            case TRACK_8_SET_SEND_3:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_3.ordinal (), 2);

            case TRACK_1_SET_SEND_4:
            case TRACK_2_SET_SEND_4:
            case TRACK_3_SET_SEND_4:
            case TRACK_4_SET_SEND_4:
            case TRACK_5_SET_SEND_4:
            case TRACK_6_SET_SEND_4:
            case TRACK_7_SET_SEND_4:
            case TRACK_8_SET_SEND_4:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_4.ordinal (), 3);

            case TRACK_1_SET_SEND_5:
            case TRACK_2_SET_SEND_5:
            case TRACK_3_SET_SEND_5:
            case TRACK_4_SET_SEND_5:
            case TRACK_5_SET_SEND_5:
            case TRACK_6_SET_SEND_5:
            case TRACK_7_SET_SEND_5:
            case TRACK_8_SET_SEND_5:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_5.ordinal (), 4);

            case TRACK_1_SET_SEND_6:
            case TRACK_2_SET_SEND_6:
            case TRACK_3_SET_SEND_6:
            case TRACK_4_SET_SEND_6:
            case TRACK_5_SET_SEND_6:
            case TRACK_6_SET_SEND_6:
            case TRACK_7_SET_SEND_6:
            case TRACK_8_SET_SEND_6:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_6.ordinal (), 5);

            case TRACK_1_SET_SEND_7:
            case TRACK_2_SET_SEND_7:
            case TRACK_3_SET_SEND_7:
            case TRACK_4_SET_SEND_7:
            case TRACK_5_SET_SEND_7:
            case TRACK_6_SET_SEND_7:
            case TRACK_7_SET_SEND_7:
            case TRACK_8_SET_SEND_7:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_7.ordinal (), 6);

            case TRACK_1_SET_SEND_8:
            case TRACK_2_SET_SEND_8:
            case TRACK_3_SET_SEND_8:
            case TRACK_4_SET_SEND_8:
            case TRACK_5_SET_SEND_8:
            case TRACK_6_SET_SEND_8:
            case TRACK_7_SET_SEND_8:
            case TRACK_8_SET_SEND_8:
                return this.getSendValue (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_8.ordinal (), 7);

            case TRACK_SELECTED_SET_SEND_1:
            case TRACK_SELECTED_SET_SEND_2:
            case TRACK_SELECTED_SET_SEND_3:
            case TRACK_SELECTED_SET_SEND_4:
            case TRACK_SELECTED_SET_SEND_5:
            case TRACK_SELECTED_SET_SEND_6:
            case TRACK_SELECTED_SET_SEND_7:
            case TRACK_SELECTED_SET_SEND_8:
                return this.getSendValue (-1, command.ordinal () - FlexiCommand.TRACK_SELECTED_SET_SEND_1.ordinal ());

            default:
                return -1;
        }
    }


    /** {@inheritDoc} */
    @Override
    public void handle (final FlexiCommand command, final int knobMode, final int value)
    {
        final ITrackBank trackBank = this.model.getCurrentTrackBank ();
        if (trackBank == null)
            return;

        final boolean isButtonPressed = this.isButtonPressed (knobMode, value);

        switch (command)
        {
            case TRACK_TOGGLE_TRACK_BANK:
                if (isButtonPressed)
                    this.toggleTrackBankCommand.execute (ButtonEvent.DOWN, 127);
                break;
            // Track: Add Audio Track
            case TRACK_ADD_AUDIO_TRACK:
                if (isButtonPressed)
                    this.model.getApplication ().addAudioTrack ();
                break;
            // Track: Add Effect Track
            case TRACK_ADD_EFFECT_TRACK:
                if (isButtonPressed)
                    this.model.getApplication ().addEffectTrack ();
                break;
            // Track: Add Instrument Track
            case TRACK_ADD_INSTRUMENT_TRACK:
                if (isButtonPressed)
                    this.model.getApplication ().addInstrumentTrack ();
                break;
            // Track: Select Previous Bank Page
            case TRACK_SELECT_PREVIOUS_BANK_PAGE:
                if (isButtonPressed)
                    this.scrollTrackLeft (true);
                break;
            // Track: Select Next Bank Page
            case TRACK_SELECT_NEXT_BANK_PAGE:
                if (isButtonPressed)
                    this.scrollTrackRight (true);
                break;
            // Track: Select Previous Track
            case TRACK_SELECT_PREVIOUS_TRACK:
                if (isButtonPressed)
                    this.scrollTrackLeft (false);
                break;
            // Track: Select Next Track
            case TRACK_SELECT_NEXT_TRACK:
                if (isButtonPressed)
                    this.scrollTrackRight (false);
                break;

            case TRACK_SCROLL_TRACKS:
                this.scrollTrack (knobMode, value);
                break;

            // Track 1-8: Select
            case TRACK_1_SELECT:
            case TRACK_2_SELECT:
            case TRACK_3_SELECT:
            case TRACK_4_SELECT:
            case TRACK_5_SELECT:
            case TRACK_6_SELECT:
            case TRACK_7_SELECT:
            case TRACK_8_SELECT:
                if (isButtonPressed)
                {
                    final ITrack track = trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SELECT.ordinal ());
                    track.select ();
                    this.mvHelper.notifySelectedTrack ();
                }
                break;

            // Track 1-8: Toggle Active
            case TRACK_1_TOGGLE_ACTIVE:
            case TRACK_2_TOGGLE_ACTIVE:
            case TRACK_3_TOGGLE_ACTIVE:
            case TRACK_4_TOGGLE_ACTIVE:
            case TRACK_5_TOGGLE_ACTIVE:
            case TRACK_6_TOGGLE_ACTIVE:
            case TRACK_7_TOGGLE_ACTIVE:
            case TRACK_8_TOGGLE_ACTIVE:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_ACTIVE.ordinal ()).toggleIsActivated ();
                break;
            // Track 1-8: Set Active
            case TRACK_1_SET_ACTIVE:
            case TRACK_2_SET_ACTIVE:
            case TRACK_3_SET_ACTIVE:
            case TRACK_4_SET_ACTIVE:
            case TRACK_5_SET_ACTIVE:
            case TRACK_6_SET_ACTIVE:
            case TRACK_7_SET_ACTIVE:
            case TRACK_8_SET_ACTIVE:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_ACTIVE.ordinal ()).setIsActivated (value > 0);
                break;
            case TRACK_SELECTED_TOGGLE_ACTIVE:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleIsActivated ();
                }
                break;
            case TRACK_SELECTED_SET_ACTIVE:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setIsActivated (value > 0);
                }
                break;

            // Track 1-8: Set Volume
            case TRACK_1_SET_VOLUME:
            case TRACK_2_SET_VOLUME:
            case TRACK_3_SET_VOLUME:
            case TRACK_4_SET_VOLUME:
            case TRACK_5_SET_VOLUME:
            case TRACK_6_SET_VOLUME:
            case TRACK_7_SET_VOLUME:
            case TRACK_8_SET_VOLUME:
                this.changeTrackVolume (knobMode, command.ordinal () - FlexiCommand.TRACK_1_SET_VOLUME.ordinal (), value);
                break;
            // Track Selected: Set Volume Track
            case TRACK_SELECTED_SET_VOLUME_TRACK:
                this.changeTrackVolume (knobMode, -1, value);
                break;

            // Track 1-8: Set Panorama
            case TRACK_1_SET_PANORAMA:
            case TRACK_2_SET_PANORAMA:
            case TRACK_3_SET_PANORAMA:
            case TRACK_4_SET_PANORAMA:
            case TRACK_5_SET_PANORAMA:
            case TRACK_6_SET_PANORAMA:
            case TRACK_7_SET_PANORAMA:
            case TRACK_8_SET_PANORAMA:
                this.changeTrackPanorama (knobMode, command.ordinal () - FlexiCommand.TRACK_1_SET_PANORAMA.ordinal (), value);
                break;
            // Track Selected: Set Panorama
            case TRACK_SELECTED_SET_PANORAMA:
                this.changeTrackPanorama (knobMode, -1, value);
                break;

            // Track 1-8: Toggle Mute
            case TRACK_1_TOGGLE_MUTE:
            case TRACK_2_TOGGLE_MUTE:
            case TRACK_3_TOGGLE_MUTE:
            case TRACK_4_TOGGLE_MUTE:
            case TRACK_5_TOGGLE_MUTE:
            case TRACK_6_TOGGLE_MUTE:
            case TRACK_7_TOGGLE_MUTE:
            case TRACK_8_TOGGLE_MUTE:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_MUTE.ordinal ()).toggleMute ();
                break;
            // Track 1-8: Set Mute
            case TRACK_1_SET_MUTE:
            case TRACK_2_SET_MUTE:
            case TRACK_3_SET_MUTE:
            case TRACK_4_SET_MUTE:
            case TRACK_5_SET_MUTE:
            case TRACK_6_SET_MUTE:
            case TRACK_7_SET_MUTE:
            case TRACK_8_SET_MUTE:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_MUTE.ordinal ()).setMute (value > 0);
                break;
            // Track Selected: Toggle Mute
            case TRACK_SELECTED_TOGGLE_MUTE:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleMute ();
                }
                break;
            // Track Selected: Set Mute
            case TRACK_SELECTED_SET_MUTE:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setMute (value > 0);
                }
                break;

            // Track 1-8: Toggle Solo
            case TRACK_1_TOGGLE_SOLO:
            case TRACK_2_TOGGLE_SOLO:
            case TRACK_3_TOGGLE_SOLO:
            case TRACK_4_TOGGLE_SOLO:
            case TRACK_5_TOGGLE_SOLO:
            case TRACK_6_TOGGLE_SOLO:
            case TRACK_7_TOGGLE_SOLO:
            case TRACK_8_TOGGLE_SOLO:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_SOLO.ordinal ()).toggleSolo ();
                break;
            // Track 1-8: Set Solo
            case TRACK_1_SET_SOLO:
            case TRACK_2_SET_SOLO:
            case TRACK_3_SET_SOLO:
            case TRACK_4_SET_SOLO:
            case TRACK_5_SET_SOLO:
            case TRACK_6_SET_SOLO:
            case TRACK_7_SET_SOLO:
            case TRACK_8_SET_SOLO:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_SOLO.ordinal ()).setSolo (value > 0);
                break;
            // Track Selected: Toggle Solo
            case TRACK_SELECTED_TOGGLE_SOLO:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleSolo ();
                }
                break;
            // Track Selected: Set Solo
            case TRACK_SELECTED_SET_SOLO:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setSolo (value > 0);
                }
                break;

            // Track 1-8: Toggle Arm
            case TRACK_1_TOGGLE_ARM:
            case TRACK_2_TOGGLE_ARM:
            case TRACK_3_TOGGLE_ARM:
            case TRACK_4_TOGGLE_ARM:
            case TRACK_5_TOGGLE_ARM:
            case TRACK_6_TOGGLE_ARM:
            case TRACK_7_TOGGLE_ARM:
            case TRACK_8_TOGGLE_ARM:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_ARM.ordinal ()).toggleRecArm ();
                break;
            // Track 1-8: Set Arm
            case TRACK_1_SET_ARM:
            case TRACK_2_SET_ARM:
            case TRACK_3_SET_ARM:
            case TRACK_4_SET_ARM:
            case TRACK_5_SET_ARM:
            case TRACK_6_SET_ARM:
            case TRACK_7_SET_ARM:
            case TRACK_8_SET_ARM:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_ARM.ordinal ()).setRecArm (value > 0);
                break;
            // Track Selected: Toggle Arm
            case TRACK_SELECTED_TOGGLE_ARM:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleRecArm ();
                }
                break;
            // Track Selected: Set Arm
            case TRACK_SELECTED_SET_ARM:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setRecArm (value > 0);
                }
                break;

            // Track 1-8: Toggle Monitor
            case TRACK_1_TOGGLE_MONITOR:
            case TRACK_2_TOGGLE_MONITOR:
            case TRACK_3_TOGGLE_MONITOR:
            case TRACK_4_TOGGLE_MONITOR:
            case TRACK_5_TOGGLE_MONITOR:
            case TRACK_6_TOGGLE_MONITOR:
            case TRACK_7_TOGGLE_MONITOR:
            case TRACK_8_TOGGLE_MONITOR:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_MONITOR.ordinal ()).toggleMonitor ();
                break;
            // Track 1-8: Set Monitor
            case TRACK_1_SET_MONITOR:
            case TRACK_2_SET_MONITOR:
            case TRACK_3_SET_MONITOR:
            case TRACK_4_SET_MONITOR:
            case TRACK_5_SET_MONITOR:
            case TRACK_6_SET_MONITOR:
            case TRACK_7_SET_MONITOR:
            case TRACK_8_SET_MONITOR:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_MONITOR.ordinal ()).setMonitor (value > 0);
                break;
            // Track Selected: Toggle Monitor
            case TRACK_SELECTED_TOGGLE_MONITOR:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleMonitor ();
                }
                break;
            // Track Selected: Set Monitor
            case TRACK_SELECTED_SET_MONITOR:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setMonitor (value > 0);
                }
                break;

            // Track 1: Toggle Auto Monitor
            case TRACK_1_TOGGLE_AUTO_MONITOR:
            case TRACK_2_TOGGLE_AUTO_MONITOR:
            case TRACK_3_TOGGLE_AUTO_MONITOR:
            case TRACK_4_TOGGLE_AUTO_MONITOR:
            case TRACK_5_TOGGLE_AUTO_MONITOR:
            case TRACK_6_TOGGLE_AUTO_MONITOR:
            case TRACK_7_TOGGLE_AUTO_MONITOR:
            case TRACK_8_TOGGLE_AUTO_MONITOR:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_TOGGLE_AUTO_MONITOR.ordinal ()).toggleAutoMonitor ();
                break;
            // Track 1: Set Auto Monitor
            case TRACK_1_SET_AUTO_MONITOR:
            case TRACK_2_SET_AUTO_MONITOR:
            case TRACK_3_SET_AUTO_MONITOR:
            case TRACK_4_SET_AUTO_MONITOR:
            case TRACK_5_SET_AUTO_MONITOR:
            case TRACK_6_SET_AUTO_MONITOR:
            case TRACK_7_SET_AUTO_MONITOR:
            case TRACK_8_SET_AUTO_MONITOR:
                if (isButtonPressed)
                    trackBank.getItem (command.ordinal () - FlexiCommand.TRACK_1_SET_AUTO_MONITOR.ordinal ()).setAutoMonitor (value > 0);
                break;
            // Track Selected: Toggle Auto Monitor
            case TRACK_SELECTED_TOGGLE_AUTO_MONITOR:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.toggleAutoMonitor ();
                }
                break;
            // Track Selected: Set Auto Monitor
            case TRACK_SELECTED_SET_AUTO_MONITOR:
                if (isButtonPressed)
                {
                    final ITrack selectedTrack = this.model.getSelectedTrack ();
                    if (selectedTrack != null)
                        selectedTrack.setAutoMonitor (value > 0);
                }
                break;

            // Track 1-8: Set Send 1
            case TRACK_1_SET_SEND_1:
            case TRACK_2_SET_SEND_1:
            case TRACK_3_SET_SEND_1:
            case TRACK_4_SET_SEND_1:
            case TRACK_5_SET_SEND_1:
            case TRACK_6_SET_SEND_1:
            case TRACK_7_SET_SEND_1:
            case TRACK_8_SET_SEND_1:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_1.ordinal (), 0, knobMode, value);
                break;

            // Track 1-8: Set Send 2
            case TRACK_1_SET_SEND_2:
            case TRACK_2_SET_SEND_2:
            case TRACK_3_SET_SEND_2:
            case TRACK_4_SET_SEND_2:
            case TRACK_5_SET_SEND_2:
            case TRACK_6_SET_SEND_2:
            case TRACK_7_SET_SEND_2:
            case TRACK_8_SET_SEND_2:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_2.ordinal (), 1, knobMode, value);
                break;

            // Track 1-8: Set Send 3
            case TRACK_1_SET_SEND_3:
            case TRACK_2_SET_SEND_3:
            case TRACK_3_SET_SEND_3:
            case TRACK_4_SET_SEND_3:
            case TRACK_5_SET_SEND_3:
            case TRACK_6_SET_SEND_3:
            case TRACK_7_SET_SEND_3:
            case TRACK_8_SET_SEND_3:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_3.ordinal (), 2, knobMode, value);
                break;

            // Track 1-8: Set Send 4
            case TRACK_1_SET_SEND_4:
            case TRACK_2_SET_SEND_4:
            case TRACK_3_SET_SEND_4:
            case TRACK_4_SET_SEND_4:
            case TRACK_5_SET_SEND_4:
            case TRACK_6_SET_SEND_4:
            case TRACK_7_SET_SEND_4:
            case TRACK_8_SET_SEND_4:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_4.ordinal (), 3, knobMode, value);
                break;

            // Track 1: Set Send 5
            case TRACK_1_SET_SEND_5:
            case TRACK_2_SET_SEND_5:
            case TRACK_3_SET_SEND_5:
            case TRACK_4_SET_SEND_5:
            case TRACK_5_SET_SEND_5:
            case TRACK_6_SET_SEND_5:
            case TRACK_7_SET_SEND_5:
            case TRACK_8_SET_SEND_5:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_5.ordinal (), 4, knobMode, value);
                break;

            // Track 1: Set Send 6
            case TRACK_1_SET_SEND_6:
            case TRACK_2_SET_SEND_6:
            case TRACK_3_SET_SEND_6:
            case TRACK_4_SET_SEND_6:
            case TRACK_5_SET_SEND_6:
            case TRACK_6_SET_SEND_6:
            case TRACK_7_SET_SEND_6:
            case TRACK_8_SET_SEND_6:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_6.ordinal (), 5, knobMode, value);
                break;

            // Track 1-8: Set Send 7
            case TRACK_1_SET_SEND_7:
            case TRACK_2_SET_SEND_7:
            case TRACK_3_SET_SEND_7:
            case TRACK_4_SET_SEND_7:
            case TRACK_5_SET_SEND_7:
            case TRACK_6_SET_SEND_7:
            case TRACK_7_SET_SEND_7:
            case TRACK_8_SET_SEND_7:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_7.ordinal (), 6, knobMode, value);
                break;

            // Track 1-8: Set Send 8
            case TRACK_1_SET_SEND_8:
            case TRACK_2_SET_SEND_8:
            case TRACK_3_SET_SEND_8:
            case TRACK_4_SET_SEND_8:
            case TRACK_5_SET_SEND_8:
            case TRACK_6_SET_SEND_8:
            case TRACK_7_SET_SEND_8:
            case TRACK_8_SET_SEND_8:
                this.changeSendVolume (command.ordinal () - FlexiCommand.TRACK_1_SET_SEND_8.ordinal (), 7, knobMode, value);
                break;

            // Track Selected: Set Send 1-8
            case TRACK_SELECTED_SET_SEND_1:
            case TRACK_SELECTED_SET_SEND_2:
            case TRACK_SELECTED_SET_SEND_3:
            case TRACK_SELECTED_SET_SEND_4:
            case TRACK_SELECTED_SET_SEND_5:
            case TRACK_SELECTED_SET_SEND_6:
            case TRACK_SELECTED_SET_SEND_7:
            case TRACK_SELECTED_SET_SEND_8:
                this.changeSendVolume (-1, command.ordinal () - FlexiCommand.TRACK_SELECTED_SET_SEND_1.ordinal (), knobMode, value);
                break;

            default:
                throw new FlexiHandlerException (command);
        }
    }


    private int getSendValue (final int trackIndex, final int sendIndex)
    {
        final ITrack track = this.getTrack (trackIndex);
        if (track == null)
            return 0;

        final ISendBank sendBank = track.getSendBank ();
        if (sendIndex >= sendBank.getPageSize ())
            return 0;

        final ISend send = sendBank.getItem (sendIndex);
        if (send == null)
            return 0;

        return send.getValue ();
    }


    private ITrack getTrack (final int trackIndex)
    {
        final ITrackBank tb = this.model.getCurrentTrackBank ();
        if (tb == null)
            return EmptyTrack.INSTANCE;
        return trackIndex < 0 ? tb.getSelectedItem () : tb.getItem (trackIndex);
    }


    private void changeTrackVolume (final int knobMode, final int trackIndex, final int value)
    {
        final ITrack track = this.getTrack (trackIndex);
        if (isAbsolute (knobMode))
            track.setVolume (value);
        else
            track.setVolume (this.limit (track.getVolume () + this.getRelativeSpeed (knobMode, value)));
    }


    private void changeTrackPanorama (final int knobMode, final int trackIndex, final int value)
    {
        final ITrack track = this.getTrack (trackIndex);
        if (isAbsolute (knobMode))
            track.setPan (value);
        else
            track.setPan (this.limit (track.getPan () + this.getRelativeSpeed (knobMode, value)));
    }


    private void changeSendVolume (final int trackIndex, final int sendIndex, final int knobMode, final int value)
    {
        final ITrack track = this.getTrack (trackIndex);
        if (track == null)
            return;

        final ISendBank sendBank = track.getSendBank ();
        if (sendIndex >= sendBank.getPageSize ())
            return;

        final ISend send = sendBank.getItem (sendIndex);
        if (send == null)
            return;

        if (isAbsolute (knobMode))
            send.setValue (value);
        else
            send.setValue (this.limit (send.getValue () + this.getRelativeSpeed (knobMode, value)));
    }


    private void scrollTrack (final int knobMode, final int value)
    {
        if (isAbsolute (knobMode))
            return;

        if (!this.increaseKnobMovement ())
            return;

        if (this.getRelativeSpeed (knobMode, value) > 0)
            this.scrollTrackRight (false);
        else
            this.scrollTrackLeft (false);
    }


    private void scrollTrackLeft (final boolean switchBank)
    {
        final ITrackBank tb = this.model.getCurrentTrackBank ();
        final ITrack sel = tb.getSelectedItem ();
        final int index = sel == null ? 0 : sel.getIndex () - 1;
        if (index == -1 || switchBank)
        {
            tb.selectPreviousPage ();
            return;
        }
        tb.getItem (index).select ();
    }


    private void scrollTrackRight (final boolean switchBank)
    {
        final ITrackBank tb = this.model.getCurrentTrackBank ();
        final ITrack sel = tb.getSelectedItem ();
        final int index = sel == null ? 0 : sel.getIndex () + 1;
        if (index == 8 || switchBank)
        {
            tb.selectNextPage ();
            return;
        }
        tb.getItem (index).select ();
    }
}
