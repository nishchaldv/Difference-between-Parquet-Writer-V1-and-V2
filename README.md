# Difference-between-Parquet-Writer-V1-and-V2

## Introduction to Apache Parquet: 
Apache Parquet is an open-source columnar storage format that can be used with any project in the Hadoop ecosystem, regardless of data processing framework, data model, or programming language. Its column-oriented structure is designed to efficiently store and retrieve data, with advanced compression and encoding schemes that improve performance when handling large datasets. Parquet is available in various programming languages, including Java, C++, and Python. It is commonly used in big data processing and analytics environments, providing efficient storage and processing capabilities for large datasets, particularly in distributed computing environments like Hadoop.

## Introduction to Apache Parquet Writer:
Parquet writer is a tool or library used to write data in the Apache Parquet format.

## Differences between Writer Versions:
The first important question is why there are two different write modes? The change was introduced in December 2013 and was dictated by the addition of new encoding formats. In order to keep the retro-compatibility, a small enumeration in ParquetProperties with 2 supported writing versions was added:
Prior to Parquet 2.0, most of the values were written with plain encoding. Only the arrival of the next version brought some new more efficient encodings, such as RLE/Bit-packing (for booleans), delta encodings (for binary and fixed-length byte arrays types), and delta encodings with binary packing (for integers).

The table below shows that different datatypes use different encoding styles in two different versions of the Parquet writer.

Data type     | Parquet Writer V1     | Parquet Writer V2
------------- | --------------------- | ------------
Boolean       | Bit packed, Plain     | RLE
Float         | Bit packed, Plain     | Plain
Double        | Bit packed, Plain     | Plain
Long          | Bit packed, Plain     | Delta Binary Packed
String        | Bit packed, Plain     | Delta Byte Array
Map           | Plain, RLE            | Delta Byte Array
Array         | Plain Dictionary, RLE |RLE Dictionary, Plain
Enum          | Bit packed, Plain     |Delta Byte Array
int           | Bit packed, Plain     |Delta Binary Packed

Different writer versions are only a result of Parquet evolution. The 2.0 version greatly improved encoding capabilities, and this change needed to be retro-compatible. Because of that, the writers were divided into two different versions, both applying different encoding methods during values writing. The document will prove that through learning tests comparing the same data written with two different writers.
Note that files written with version='2.0' may not be readable in all Parquet implementations, so version='1.0' is likely the choice that maximizes file compatibility. Some features, such as lossless storage of nanosecond timestamps as INT64 physical storage, are only available with version='2.0'. The Parquet 2.0.0 format version also introduced a new serialized data page format Dictionary Encoding Data Page format. This can be enabled separately using the data_page_version option.
Coerce_timestamps – Cast timestamps a particular resolution. For version='1.0' , nanoseconds will be cast to microseconds ('us'), and seconds to milliseconds ('ms'). For version='2.0', the original resolution is preserved, and no casting is done by default. The casting might result in the loss of data.
You can specify the engine version for writing out Arrow data using the environment variable ARROW_PARQUET_WRITER_ENGINE, which allows you to override the default behavior. The V2 engine supports all nested types, while the legacy V1 engine will be removed in a future release.

























