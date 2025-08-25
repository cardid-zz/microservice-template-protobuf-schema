package info.test.proto.services.flights;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Сервис для работы с flights
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.1)",
    comments = "Source: flights/flights_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlightsServiceGrpc {

  private FlightsServiceGrpc() {}

  public static final String SERVICE_NAME = "flights.FlightsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<info.test.proto.services.flights.GetFlightsRequest,
      info.test.proto.services.flights.GetFlightsResponse> getGetFlightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlights",
      requestType = info.test.proto.services.flights.GetFlightsRequest.class,
      responseType = info.test.proto.services.flights.GetFlightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<info.test.proto.services.flights.GetFlightsRequest,
      info.test.proto.services.flights.GetFlightsResponse> getGetFlightsMethod() {
    io.grpc.MethodDescriptor<info.test.proto.services.flights.GetFlightsRequest, info.test.proto.services.flights.GetFlightsResponse> getGetFlightsMethod;
    if ((getGetFlightsMethod = FlightsServiceGrpc.getGetFlightsMethod) == null) {
      synchronized (FlightsServiceGrpc.class) {
        if ((getGetFlightsMethod = FlightsServiceGrpc.getGetFlightsMethod) == null) {
          FlightsServiceGrpc.getGetFlightsMethod = getGetFlightsMethod =
              io.grpc.MethodDescriptor.<info.test.proto.services.flights.GetFlightsRequest, info.test.proto.services.flights.GetFlightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFlights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  info.test.proto.services.flights.GetFlightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  info.test.proto.services.flights.GetFlightsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FlightsServiceMethodDescriptorSupplier("GetFlights"))
              .build();
        }
      }
    }
    return getGetFlightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlightsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightsServiceStub>() {
        @java.lang.Override
        public FlightsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightsServiceStub(channel, callOptions);
        }
      };
    return FlightsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlightsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightsServiceBlockingStub>() {
        @java.lang.Override
        public FlightsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightsServiceBlockingStub(channel, callOptions);
        }
      };
    return FlightsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlightsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightsServiceFutureStub>() {
        @java.lang.Override
        public FlightsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightsServiceFutureStub(channel, callOptions);
        }
      };
    return FlightsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Сервис для работы с flights
   * </pre>
   */
  public static abstract class FlightsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Получить полеты
     * </pre>
     */
    public void getFlights(info.test.proto.services.flights.GetFlightsRequest request,
        io.grpc.stub.StreamObserver<info.test.proto.services.flights.GetFlightsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFlightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFlightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                info.test.proto.services.flights.GetFlightsRequest,
                info.test.proto.services.flights.GetFlightsResponse>(
                  this, METHODID_GET_FLIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Сервис для работы с flights
   * </pre>
   */
  public static final class FlightsServiceStub extends io.grpc.stub.AbstractAsyncStub<FlightsServiceStub> {
    private FlightsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Получить полеты
     * </pre>
     */
    public void getFlights(info.test.proto.services.flights.GetFlightsRequest request,
        io.grpc.stub.StreamObserver<info.test.proto.services.flights.GetFlightsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFlightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Сервис для работы с flights
   * </pre>
   */
  public static final class FlightsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FlightsServiceBlockingStub> {
    private FlightsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Получить полеты
     * </pre>
     */
    public info.test.proto.services.flights.GetFlightsResponse getFlights(info.test.proto.services.flights.GetFlightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFlightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Сервис для работы с flights
   * </pre>
   */
  public static final class FlightsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FlightsServiceFutureStub> {
    private FlightsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Получить полеты
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<info.test.proto.services.flights.GetFlightsResponse> getFlights(
        info.test.proto.services.flights.GetFlightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFlightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FLIGHTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlightsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlightsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FLIGHTS:
          serviceImpl.getFlights((info.test.proto.services.flights.GetFlightsRequest) request,
              (io.grpc.stub.StreamObserver<info.test.proto.services.flights.GetFlightsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FlightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlightsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return info.test.proto.services.flights.FlightsServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlightsService");
    }
  }

  private static final class FlightsServiceFileDescriptorSupplier
      extends FlightsServiceBaseDescriptorSupplier {
    FlightsServiceFileDescriptorSupplier() {}
  }

  private static final class FlightsServiceMethodDescriptorSupplier
      extends FlightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FlightsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlightsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlightsServiceFileDescriptorSupplier())
              .addMethod(getGetFlightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
