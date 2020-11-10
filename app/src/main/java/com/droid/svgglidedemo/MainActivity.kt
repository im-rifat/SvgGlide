package com.droid.svgglidedemo

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.droid.svgglidedemo.glide.GlideApp
import com.github.chrisbanes.photoview.PhotoView


class MainActivity : AppCompatActivity() {

    private val STICKERS = mutableListOf<Any>()

    private lateinit var preview: PhotoView

    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str = """<?xml version="1.0" encoding="iso-8859-1"?>
<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 216.283 241.858" style="enable-background:new 0 0 216.283 241.858;" xml:space="preserve">
    <g id="Layer_24">
        <path id="one" style="fill:#C09CC9;" d="M184.527,153.799c1.699-4.994,3.096-10.083,4.212-15.244 c0.551-2.527,1.009-5.078,1.412-7.627c0.388-2.479,0.651-4.971,0.937-7.462c1.192-10.581,2.302-21.174,2.633-31.815 c0.181-5.754,0.107-11.519-0.308-17.26c-0.407-5.54-1.186-11.079-2.538-16.465c-1.232-4.924-3.05-9.764-5.634-14.152 c-1.096-1.875-2.385-3.666-3.856-5.279c-1.361-1.519-2.943-2.823-4.579-4.045c-3.434-2.552-7.379-4.413-11.424-5.801 c-4.224-1.435-8.672-2.243-13.122-2.481c-0.764-0.035-1.541-0.058-2.311-0.058c-5.436-0.001-10.925,1.056-15.846,3.404 c-2.658,1.281-5.104,3.038-7.158,5.137c-1.052,1.068-1.981,2.266-2.799,3.5c-1.861,1.222-3.583,2.657-5.16,4.199 c-3.342,3.262-6.122,7.106-8.648,11.021c-2.488,3.878-4.721,7.923-6.928,11.969c-1.656,3.024-3.321,6.062-5.137,9.015 c-2.722,4.437-5.683,8.731-8.85,12.871c-6.642,8.588-14.271,16.371-22.823,23.06c-0.026,0.024-0.06,0.048-0.083,0.072 c-2.537,1.956-5.173,3.831-7.854,5.588c-2.435,1.612-4.946,3.108-7.472,4.578c-0.744,0.435-1.493,0.86-2.242,1.287 c-1.084,0.619-2.169,1.236-3.258,1.846c-2.94,1.648-5.889,3.28-8.808,4.957c-9.182,5.291-18.221,11.234-24.959,19.537 c-1.732,2.136-3.298,4.401-4.686,6.786c-1.467,2.527-2.681,5.184-3.714,7.899c-2.108,5.528-3.344,11.448-3.512,17.368 c-0.146,5.208,0.689,10.475,2.409,15.386c1.673,4.781,4.188,9.218,7.272,13.227c6.54,8.481,15.35,14.971,24.709,20.046 c4.892,2.658,9.999,4.912,15.198,6.893c5.325,2.017,10.77,3.618,16.369,4.661c5.354,0.997,10.806,1.483,16.264,1.436 c5.243-0.036,10.485-0.63,15.634-1.649c10.14-2.017,19.846-5.99,28.719-11.246c9.115-5.373,17.367-12.183,24.687-19.787 c7.521-7.817,14.081-16.584,19.645-25.884c3.029-5.05,5.744-10.287,8.159-15.659c0.502-1.116,0.992-2.237,1.468-3.365 C181.998,160.824,183.331,157.334,184.527,153.799z M189.216,68.139l-0.003-0.012c-0.011-0.035-0.008-0.082-0.019-0.119 C189.202,68.045,189.204,68.092,189.216,68.139z M189.213,68.163l0.003,0.083l0.032,0.225c-0.235-1.708-0.497-3.369-0.79-4.959 C188.756,65.054,189.001,66.609,189.213,68.163z M132.154,34.817c0.007-0.012,0.012-0.012,0.012-0.023 c0.241-0.037,0.475-0.072,0.712-0.107h0.009C132.631,34.721,132.391,34.769,132.154,34.817z M154.895,29.942l0.007,0 c0.293,0.033,0.589,0.067,0.892,0.102c0.02,0.001,0.038,0.005,0.058,0.005l-0.008,0c-0.017-0.002-0.033-0.004-0.05-0.006 c-0.024-0.001-0.049,0-0.068-0.006c0.051,0.011,0.094,0.012,0.14,0.023l0.049,0.011C155.574,30.023,155.226,29.976,154.895,29.942z"/>
        <path id="two" style="fill-rule:evenodd;clip-rule:evenodd;fill:#CDDC2D;" d="M131.04,65.731L131.04,65.731 c0.032,0.047,0.035,0.084,0.047,0.13C131.083,65.814,131.051,65.766,131.04,65.731L131.04,65.731z M167.942,20.896 c1.601-2.921,3.475-5.689,5.506-8.345c2.08-2.681,4.306-5.255,6.537-7.806c0.327-0.367,0.521-0.771,0.521-1.269 c0.003-0.148-0.014-0.295-0.051-0.438l0.027-0.024c0.726-0.641,0.653-1.85,0-2.515C180.13,0.154,179.7,0,179.261,0 c-0.455,0-0.926,0.179-1.293,0.498l0.005,0c-4.409,3.903-8.357,8.304-11.632,13.203c-1.296,1.955-2.47,3.998-3.508,6.109 l-0.358-0.058c-0.228-0.036-0.474-0.084-0.712-0.119c-0.328-0.451-0.855-0.748-1.448-0.748c-7.646,0.011-15.314,0.51-22.859,1.767 c-4.014,0.652-8.007,1.578-11.887,2.859c-3.69,1.221-7.331,2.812-10.617,4.922c-1.561,1.02-3.06,2.171-4.425,3.452 c-1.182,1.115-2.23,2.361-3.203,3.665c-0.649,0.878-1.187,1.804-1.6,2.823c-0.34,0.819-0.439,1.698-0.298,2.574 c0.278,1.625,1.839,2.575,3.334,2.847c1.994,0.355,4.011,0.095,5.991-0.201c2.409-0.392,4.792-0.985,7.141-1.614 c2.613-0.712,5.208-1.506,7.783-2.337c2.314-0.747,4.602-1.519,6.903-2.3c-1.578,2.502-3.083,5.042-4.46,7.675 c-1.634,3.119-3.108,6.382-4.14,9.762c-0.932,3.013-1.472,6.216-1.032,9.36c0.197,1.376,0.63,2.681,1.293,3.89 c0.741,1.341,1.804,2.385,3.001,3.286c1.05,0.783,2.279,1.376,3.548,1.66c1.281,0.285,2.574,0.262,3.856-0.023 c1.194-0.261,2.336-0.819,3.357-1.471c1.168-0.736,2.206-1.66,3.167-2.633c2.154-2.207,3.904-4.816,5.469-7.45 c2.215-3.761,4.021-7.746,5.683-11.768c0.526-1.257,1.02-2.526,1.505-3.808c-0.061,2.325-0.083,4.65,0.012,6.964 c0.14,3.179,0.463,6.393,1.245,9.49c0.689,2.681,1.805,5.374,3.738,7.403c1.894,1.981,4.579,2.918,7.271,2.812 c1.285-0.048,2.528-0.38,3.666-0.985c1.089-0.57,1.922-1.448,2.656-2.408c0.717-0.949,1.187-2.076,1.579-3.179 c0.42-1.175,0.651-2.385,0.818-3.606c0.413-2.931,0.415-5.872,0.226-8.815c-0.197-2.906-0.558-5.8-1.044-8.671 c2.053,1.732,4.116,3.416,6.239,5.053c2.454,1.862,4.947,3.631,7.58,5.195c1.205,0.712,2.433,1.377,3.688,1.959 c1.2,0.545,2.432,1.032,3.702,1.364c2.089,0.532,4.533,0.639,6.394-0.606c2.197-1.47,3.06-4.246,3.002-6.785 c-0.068-3.346-1.851-6.322-3.89-8.861c-2.296-2.883-5.209-5.243-8.163-7.414c-2.78-2.041-5.729-3.879-8.741-5.564 c-3.316-1.875-6.75-3.523-10.261-5.006C174.43,22.855,171.222,21.743,167.942,20.896L167.942,20.896z M174.311,65.659 c-0.021,0.024-0.033,0.048-0.033,0.072c0.001-0.011,0.012-0.024,0.012-0.048c0.021,0,0.012-0.011,0.012-0.024H174.311 L174.311,65.659z M175.358,61.579c-0.011,0.084-0.024,0.166-0.035,0.261C175.337,61.744,175.347,61.663,175.358,61.579 L175.358,61.579z M161.82,57.77c0.011,0.048,0.003,0.083,0.003,0.131c0.008-0.035,0-0.082-0.012-0.118L161.82,57.77L161.82,57.77z M161.82,57.664l-0.042-0.238c0.086,0.57,0.152,1.115,0.246,1.626c-0.076-0.44-0.153-0.878-0.213-1.317L161.82,57.664 L161.82,57.664z M185.458,46.348c0.502,0.379,0.969,0.747,1.43,1.103c-0.427-0.319-0.842-0.64-1.257-0.96h0.008 c0.053,0.047,0.111,0.094,0.169,0.141c-0.062-0.048-0.129-0.107-0.202-0.154L185.458,46.348L185.458,46.348z M108.983,40.285 c0.011,0.012,0.016,0.037,0.027,0.048c-0.016-0.012-0.023-0.036-0.035-0.048L108.983,40.285L108.983,40.285z M108.909,40.143 c0-0.023-0.006-0.035,0.008-0.058c0.013,0.023,0.047,0.07,0.071,0.095c-0.014-0.012-0.048-0.024-0.084-0.036H108.909 L108.909,40.143z M158.222,38.363c0,0.047-0.005,0.095-0.005,0.142c0.005,0,0,0-0.012,0c0.017-0.047,0.012-0.095,0.012-0.142 H158.222L158.222,38.363z M172.902,37.296c0.043,0.202,0.084,0.404,0.13,0.605c-0.024,0.023-0.036,0.036-0.046,0.047 L172.902,37.296L172.902,37.296z M128.456,26.324c-0.011,0.011-0.026,0.023-0.039,0.023c-0.442,0.13-0.901,0.274-1.34,0.403 C127.55,26.607,127.991,26.465,128.456,26.324L128.456,26.324z M148.261,23.001c-0.086,0.013-0.165,0.024-0.246,0.036 c0.086-0.012,0.154-0.023,0.237-0.036L148.261,23.001L148.261,23.001z"/>
        <path id="fixed" d="M48.952,121.811c-1.084,0.619-2.169,1.236-3.258,1.846c-0.631-0.614-1.235-1.254-1.808-1.922 c-2.052-2.397-3.797-5.042-5.02-7.96c-0.651-1.519-1.211-3.061-1.636-4.65c-0.415-1.637-0.707-3.287-0.926-4.959 c-0.403-3.31-0.379-6.643-0.059-9.964c0.048-0.487,0.171-0.902,0.523-1.258c0.332-0.331,0.79-0.521,1.256-0.521 c0.475,0,0.933,0.19,1.258,0.522c0.309,0.31,0.571,0.819,0.522,1.258c-0.32,3.357-0.335,6.738,0.083,10.083 c0.393,2.669,1.077,5.29,2.087,7.794c0.938,2.147,2.118,4.151,3.511,6.025C46.533,119.437,47.704,120.666,48.952,121.811z M215.383,151.864c-0.267-0.166-0.594-0.236-0.902-0.236c-0.165,0-0.321,0.011-0.474,0.058h0.009 c-0.48,0.131-0.793,0.428-1.066,0.818c-0.236,0.322-0.462,0.641-0.712,0.962c-1.5,1.911-3.202,3.642-5.114,5.159 c-1.884,1.424-3.926,2.61-6.096,3.547c-2.674,1.103-5.481,1.815-8.352,2.219c-4.025,0.492-8.102,0.384-12.128-0.128 c-0.475,1.128-0.966,2.249-1.468,3.365c6.116,0.889,12.359,0.94,18.4-0.546c3.563-0.878,7-2.36,10.048-4.388 c3.359-2.231,6.156-5.125,8.493-8.399C216.59,153.503,216.165,152.316,215.383,151.864z M66.299,127.784 c-0.107,0.19-0.207,0.369-0.291,0.546c-0.723,0.06-1.423,0.558-1.601,1.306c-0.382,1.731-0.675,3.546-0.593,5.338 c0.04,0.795,0.51,1.495,1.304,1.721c0.808,0.224,1.555-0.155,2.006-0.819c1.45-2.147,2.373-4.591,2.479-7.188 c0.038-0.784-0.569-1.507-1.305-1.709c-0.152-0.047-0.309-0.07-0.463-0.07c-0.607,0-1.245,0.319-1.541,0.877H66.299L66.299,127.784 z M141.087,141.142c-1.42,1.601-1.624,3.949-1.541,6.002c0.036,0.973,0.782,1.779,1.779,1.779c0.104,0,0.179-0.011,0.26-0.024 c0.132,0.203,0.321,0.369,0.547,0.5c0.727,0.426,1.53,0.249,2.146-0.274c0.813-0.688,1.519-1.471,2.065-2.373 c0.51-0.831,0.759-1.744,0.854-2.692c0.126-1.448-0.64-3.013-1.921-3.714c-0.494-0.272-1.033-0.403-1.567-0.403 C142.741,139.942,141.775,140.382,141.087,141.142L141.087,141.142z M103.976,199.979l-0.007,0c0.06,0.023,0.113,0.047,0.167,0.071 C104.076,200.027,104.029,200.003,103.976,199.979L103.976,199.979z M115.015,190.608c-0.013,0.119-0.021,0.238-0.049,0.344 C114.989,190.845,115.004,190.726,115.015,190.608L115.015,190.608z M116.04,184.096l-0.007,0c0.333-0.332,0.787-0.522,1.258-0.522 c0.913,0,1.856,0.818,1.78,1.779c-0.071,0.819-0.127,1.637-0.203,2.443c-0.296,3.322-0.66,6.738-1.933,9.834 c-0.617,1.519-1.419,2.99-2.61,4.129c-1.164,1.114-2.62,1.981-4.223,2.313c-3.987,0.806-8.358-0.427-11.152-3.44 c-2.741-2.966-4.114-6.88-4.899-10.771c-0.095-0.474-0.069-0.938,0.177-1.364c0.237-0.404,0.628-0.701,1.068-0.819 c0.878-0.249,2.006,0.285,2.194,1.246c0.358,1.815,0.848,3.594,1.543,5.315c0.499,1.114,1.098,2.171,1.815,3.155 c0.486,0.616,1.034,1.162,1.636,1.672c0.559,0.404,1.16,0.748,1.768,1.032c0.713,0.274,1.452,0.464,2.196,0.582 c0.782,0.083,1.573,0.106,2.337,0.024c0.486-0.084,0.966-0.214,1.424-0.38c0.391-0.19,0.77-0.403,1.126-0.665 c0.391-0.32,0.744-0.676,1.056-1.067c0.487-0.665,0.884-1.377,1.209-2.135c0.748-1.911,1.158-3.939,1.424-5.956 c0.213-1.72,0.364-3.428,0.487-5.148C115.548,184.866,115.677,184.452,116.04,184.096L116.04,184.096z"/>
        <path id="three" style="fill-rule:evenodd;clip-rule:evenodd;fill:#9D70B1;" d="M38.21,156.859L38.21,156.859 c0,0.012-0.007,0.012-0.007,0.024c0.007-0.012,0-0.012,0-0.023L38.21,156.859L38.21,156.859z M39.929,155.091 c-0.011,0.036-0.03,0.072-0.052,0.107c0.031-0.035,0.035-0.071,0.047-0.106L39.929,155.091L39.929,155.091z M48.694,145.731 c-0.064,0.013-0.111,0.024-0.169,0.024C48.587,145.756,48.63,145.744,48.694,145.731L48.694,145.731z M47.188,140.441 c-1.527,0.771-2.912,1.851-4.109,3.074c-0.578,0.225-1.152,0.486-1.709,0.782c-1.303,0.688-2.527,1.636-3.511,2.741 c-1.112,1.233-1.898,2.669-2.456,4.222c-0.61,1.673-0.795,3.512-0.783,5.279c0.024,1.827,0.274,3.713,0.926,5.422 c1.223,3.25,3.618,5.801,6.501,7.675c2.985,1.922,6.43,2.966,9.917,3.393c1.663,0.212,3.334,0.213,4.994,0.023 c1.687-0.191,3.333-0.546,4.922-1.187c1.558-0.63,2.942-1.458,4.236-2.538c0.973-0.808,1.791-1.815,2.455-2.883 c1.327-2.076,1.911-4.567,1.97-7.023c0.051-2.468-0.487-4.958-1.376-7.26c-1.819-4.721-5.197-9.098-9.728-11.482 c-1.86-0.985-3.89-1.566-6.002-1.673c-0.171,0-0.345-0.012-0.522-0.012c-1.987,0-3.949,0.557-5.729,1.447H47.188L47.188,140.441z M151.496,183.206c-0.075,0.023-0.136,0.048-0.195,0.071c0.067-0.024,0.118-0.048,0.19-0.071H151.496L151.496,183.206z M140.328,163.336c-0.064,0.059-0.142,0.107-0.203,0.166C140.19,163.443,140.257,163.396,140.328,163.336L140.328,163.336z M140.906,157.226c-3.15,1.198-6.011,3.179-8.087,5.837c-0.519,0.676-1.009,1.364-1.435,2.112c-0.46,0.794-0.83,1.648-1.162,2.514 c-0.612,1.637-0.903,3.416-0.949,5.171c-0.047,1.827,0.272,3.702,0.925,5.41c0.673,1.696,1.625,3.204,2.86,4.555 c1.143,1.245,2.562,2.277,4.056,3.072c1.54,0.819,3.215,1.399,4.924,1.732c3.641,0.699,7.414,0.296,10.818-1.186 c1.727-0.747,3.275-1.803,4.71-3.013c1.288-1.08,2.396-2.372,3.286-3.783c1.568-2.468,2.313-5.469,2.075-8.376 c-0.219-2.788-1.245-5.504-2.918-7.758c-0.002-0.011-0.023-0.036-0.023-0.048c0.095-0.224,0.142-0.462,0.142-0.711 c0.007-0.499-0.202-0.89-0.522-1.258c-2.269-2.633-5.386-4.471-8.813-5.159c-1.1-0.214-2.231-0.321-3.346-0.321 c-2.227,0-4.46,0.416-6.549,1.21L140.906,157.226L140.906,157.226z"/>
        <path id="fixed" style="fill-rule:evenodd;clip-rule:evenodd;fill:#FFFFFF;" d="M110.51,64.021 c-4.527,8.411-8.344,17.261-14.169,24.889c-1.066,1.376-2.193,2.692-3.381,3.95c-0.664,0.711-0.699,1.814,0,2.515 c0.147,0.141,0.298,0.249,0.474,0.331c0.069,0.106,0.143,0.201,0.227,0.285c0.663,0.652,1.873,0.712,2.515,0 c4.01-4.46,7.853-9.075,11.091-14.117c1.673-2.609,3.12-5.338,4.319-8.196c1.167-2.811,1.934-5.742,2.23-8.754 c0.089-0.784-0.593-1.519-1.305-1.72c-0.143-0.036-0.297-0.059-0.451-0.059C111.439,63.146,110.802,63.465,110.51,64.021 L110.51,64.021z M85.207,102.184c-0.139,0.108-0.289,0.215-0.443,0.309c-0.272-0.19-0.594-0.296-0.949-0.261 c-0.712,0.046-1.223,0.356-1.603,0.961c-0.166,0.249-0.236,0.534-0.248,0.83c-0.035,0.06-0.071,0.13-0.119,0.189 c-0.066,0.083-0.142,0.155-0.238,0.226c-0.213,0.213-0.367,0.486-0.462,0.783c-0.113,0.461-0.06,0.96,0.19,1.375 c0.466,0.795,1.624,1.174,2.431,0.641c1.045-0.713,2.22-1.211,3.239-1.969c0.401-0.297,0.687-0.581,0.818-1.068 c0.127-0.462,0.06-0.96-0.178-1.376c-0.23-0.392-0.63-0.688-1.068-0.818c-0.155-0.035-0.332-0.058-0.511-0.058 C85.762,101.948,85.441,102.018,85.207,102.184L85.207,102.184z"/>
    </g>
</svg>
"""

        val url = "https://filebin.net/jqwho9kthjbd1qs2/def_assets_food_004.svg?t=8l0h4rq6"

        val uri = Uri.parse("file:///android_asset/def_assets_food_002.svg")

        STICKERS.add(url)
        STICKERS.add(uri)
        STICKERS.add(R.raw.def_assets_food_001)
        STICKERS.add(str)

        preview = findViewById(R.id.preview)
        preview.maximumScale = 20f

        addListenerOnSpinnerItemSelection()
    }

    private fun addListenerOnSpinnerItemSelection() {
        spinner = findViewById<Spinner>(R.id.spinner)
        spinner.setOnItemSelectedListener(CustomOnItemSelectedListener(this))
    }

    private fun loadSticker(pos: Int) {
        GlideApp.with(this)
            .load(STICKERS[pos])
            .override(128)
            .into(preview)
    }

    class CustomOnItemSelectedListener(private val mainActivity: MainActivity) : OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>,
            view: View?,
            pos: Int,
            id: Long
        ) {
            mainActivity.loadSticker(pos)
        }

        override fun onNothingSelected(arg0: AdapterView<*>?) {
            // TODO Auto-generated method stub
        }
    }
}