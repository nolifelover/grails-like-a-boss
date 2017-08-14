FROM java:8
MAINTAINER Eduardo Cuomo <eduardo.cuomo@patagonian.it>

ARG GRAILS_VERSION=3.2.9

# Cache GRADLE
VOLUME ["/gradle"]
ENV GRADLE_USER_HOME /gradle

# Install Grails
WORKDIR /usr/lib/jvm
RUN wget https://github.com/grails/grails-core/releases/download/v$GRAILS_VERSION/grails-$GRAILS_VERSION.zip && \
    unzip grails-$GRAILS_VERSION.zip && \
    rm -rf grails-$GRAILS_VERSION.zip && \
    ln -s grails-$GRAILS_VERSION grails

 # Setup Grails path.
ENV GRAILS_HOME /usr/lib/jvm/grails
ENV PATH $GRAILS_HOME/bin:$PATH

# Setup grails profiles
RUN wget https://codeload.github.com/grails/grails-profile-repository/zip/master && \
    unzip master && \
    mv grails-profile-repository-master/profiles/ $GRAILS_HOME && \
    rm -rf master && \
    rm -rf grails-profile-repository-master

# Create App Directory
RUN mkdir /app

# Set Workdir
WORKDIR /app

# Set Default Behavior
ENTRYPOINT ["grails"]

