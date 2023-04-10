package com.quid.commerce.order.domain.validate;

@FunctionalInterface
public interface Pipe<I> {

    I execute(I input);

    default Pipe<I> addPipe(Pipe<I> nextPipe) {
        return input -> nextPipe.execute(execute(input));
    }

    static <I> Pipe<I> of(Pipe<I> pipe) {
        return pipe;
    }
}