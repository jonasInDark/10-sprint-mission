package com.sprint.mission.service.file;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.service.ChannelService;

public class FileChannelService extends FileBaseService<Channel, ChannelService> implements ChannelService {

    public FileChannelService(ChannelService channelService) {
        super(channelService, "chn");
    }

    @Override
    public Channel create(String channelName) {
        ChannelService service = getService();
        Channel channel = service.create(channelName);
        save(channel);
        return channel;
    }
}
