package com.wrapper.spotify.requests.data.follow;

import com.google.common.base.Joiner;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.wrapper.spotify.exceptions.*;
import com.wrapper.spotify.model_objects.ModelObjectType;
import com.wrapper.spotify.requests.AbstractRequest;

import java.io.IOException;

public class CheckCurrentUserFollowsArtistsOrUsersRequest extends AbstractRequest {

  private CheckCurrentUserFollowsArtistsOrUsersRequest(final Builder builder) {
    super(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Boolean[] get() throws
          IOException,
          NoContentException,
          BadRequestException,
          UnauthorizedException,
          ForbiddenException,
          NotFoundException,
          TooManyRequestsException,
          InternalServerErrorException,
          BadGatewayException,
          ServiceUnavailableException {
    return new Gson().fromJson(new JsonParser().parse(getJson()).getAsJsonArray(), Boolean[].class);
  }

  public SettableFuture<Boolean[]> getAsync() throws
          IOException,
          NoContentException,
          BadRequestException,
          UnauthorizedException,
          ForbiddenException,
          NotFoundException,
          TooManyRequestsException,
          InternalServerErrorException,
          BadGatewayException,
          ServiceUnavailableException {
    return executeAsync(new Gson().fromJson(new JsonParser().parse(getJson()).getAsJsonArray(), Boolean[].class));
  }

  public static final class Builder extends AbstractRequest.Builder<Builder> {

    public Builder type(final ModelObjectType type) {
      assert (type != null);
      return setFormParameter("type", type);
    }

    public Builder ids(final String... ids) {
      assert (ids != null);
      return setFormParameter("ids", Joiner.on(",").join(ids));
    }

    @Override
    public CheckCurrentUserFollowsArtistsOrUsersRequest build() {
      setPath("/v1/me/following/contains");
      return new CheckCurrentUserFollowsArtistsOrUsersRequest(this);
    }
  }
}
