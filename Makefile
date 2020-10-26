
all: build

%.o: %.cpp
	$(CXX) -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux $< -o $@

libnativeload.so: src/main/cpp/com/globalload/com_globalload_LibraryLoaderJNI.o
	$(CXX) -shared -fPIC -o $@ $< -lc

build: libnativeload.so
	$(eval _resources_path = src/main/resources)
	mkdir -p ${_resources_path}
	cp $@ ${_resources_path}

clean:
	rm -f *.o *.so

.PHONY: all build install clean