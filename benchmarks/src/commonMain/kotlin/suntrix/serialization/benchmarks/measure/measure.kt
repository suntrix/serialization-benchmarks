package suntrix.serialization.benchmarks.measure

import com.goncalossilva.resources.Resource
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun <Serializer, Model> measure(
    title: String,
    fileName: String,
    serializerFactory: () -> Serializer,
    deserialize: (Serializer, String) -> Model,
    serialize: (Serializer, Model) -> String
) {
    val jsonString = Resource("src/commonMain/resources/$fileName").readText()

    val (
        serializerCreationTimes,
        deserializationTimes,
        serializationTimes,
        combinedDeserializationTimes,
        combinedSerializationTimes
    ) = (0..5).map {
        val serializer: Serializer
        val serializerCreationTime = measureTime {
            serializer = serializerFactory()
        }

        val model: Model
        val deserializationTime = measureTime {
            model = deserialize(serializer, jsonString)
        }

        val serializationTime = measureTime {
            serialize(serializer, model)
        }

        Triple(serializerCreationTime, deserializationTime, serializationTime)
    }.run {
        arrayOf(
            map { it.first },
            map { it.second },
            map { it.third },
            map { (first, second, _) -> (first + second) },
            map { (first, _, third) -> (first + third) }
        )
    }

    println()
    println(title)
    println("Serializer/adapter creation times:  $serializerCreationTimes")
    println("Deserialization times:              $deserializationTimes")
    println("Serialization times:                $serializationTimes")
    println("Combined deserialization times:     $combinedDeserializationTimes")
    println("Combined serialization times:       $combinedSerializationTimes")
}

fun <T1, T2, T3> List<Triple<T1, T2, T3>>.flip(): Triple<List<T1>, List<T2>, List<T3>> = Triple(
    map { it.first },
    map { it.second },
    map { it.third }
)