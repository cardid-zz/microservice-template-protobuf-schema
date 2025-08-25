package info.test.proto.services.flights;

import static info.test.proto.services.flights.FlightsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by VertxGrpc generator",
comments = "Source: flights/flights_service.proto")
public final class VertxFlightsServiceGrpc {
    private VertxFlightsServiceGrpc() {}

    public static FlightsServiceVertxStub newVertxStub(io.grpc.Channel channel) {
        return new FlightsServiceVertxStub(channel);
    }

    /**
     * <pre>
     *  Сервис для работы с flights
     * </pre>
     */
    public static final class FlightsServiceVertxStub extends io.grpc.stub.AbstractStub<FlightsServiceVertxStub> {
        private final io.vertx.core.impl.ContextInternal ctx;
        private FlightsServiceGrpc.FlightsServiceStub delegateStub;

        private FlightsServiceVertxStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = FlightsServiceGrpc.newStub(channel);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        private FlightsServiceVertxStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = FlightsServiceGrpc.newStub(channel).build(channel, callOptions);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        @Override
        protected FlightsServiceVertxStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FlightsServiceVertxStub(channel, callOptions);
        }

        /**
         * <pre>
         *  Получить полеты
         * </pre>
         */
        public io.vertx.core.Future<info.test.proto.services.flights.GetFlightsResponse> getFlights(info.test.proto.services.flights.GetFlightsRequest request) {
            return io.vertx.grpc.stub.ClientCalls.oneToOne(ctx, request, delegateStub::getFlights);
        }

    }

    /**
     * <pre>
     *  Сервис для работы с flights
     * </pre>
     */
    public static abstract class FlightsServiceVertxImplBase implements io.grpc.BindableService {
        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public FlightsServiceVertxImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  Получить полеты
         * </pre>
         */
        public io.vertx.core.Future<info.test.proto.services.flights.GetFlightsResponse> getFlights(info.test.proto.services.flights.GetFlightsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            info.test.proto.services.flights.FlightsServiceGrpc.getGetFlightsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            info.test.proto.services.flights.GetFlightsRequest,
                                            info.test.proto.services.flights.GetFlightsResponse>(
                                            this, METHODID_GET_FLIGHTS, compression)))
                    .build();
        }
    }

    private static final int METHODID_GET_FLIGHTS = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final FlightsServiceVertxImplBase serviceImpl;
        private final int methodId;
        private final String compression;

        MethodHandlers(FlightsServiceVertxImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_FLIGHTS:
                    io.vertx.grpc.stub.ServerCalls.oneToOne(
                            (info.test.proto.services.flights.GetFlightsRequest) request,
                            (io.grpc.stub.StreamObserver<info.test.proto.services.flights.GetFlightsResponse>) responseObserver,
                            compression,
                            serviceImpl::getFlights);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
